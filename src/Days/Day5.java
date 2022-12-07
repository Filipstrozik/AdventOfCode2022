package Days;

public class Day5 {

    public int solvePartOne() {
        var inputList = puzzleInputParser.getInputAsStringList();
        Map<Integer, ArrayDeque<String>> containerStacks = transformInputToContainerStackMap(inputList);

        //Execute all move orders
        for (String moveOrder : inputList) {
            //Skip all the non-move order lines
            if (!moveOrder.contains("move"))
                continue;

            //We just need the three numbers from our move order.
            var orderSplit = Arrays.stream(moveOrder.split("\\s+"))
                    .filter(s -> s.matches("[0-9]+"))
                    .map(Integer::parseInt)
                    .toList();

            //Now we need to move [0] containers from mapIndex [1] to [2]
            for (int i = 0; i < orderSplit.get(0); i++) {
                var container = containerStacks.get(orderSplit.get(1) - 1).pop();
                containerStacks.get(orderSplit.get(2) - 1).addFirst(container);
            }
        }

        StringBuilder resultString = new StringBuilder();
        containerStacks.values().forEach(stack -> resultString.append(stack.getFirst()));

        System.out.printf("The top container of all stacks spell out: %s%n", resultString);

        return 0;
    }


    private Map<Integer, ArrayDeque<String>> transformInputToContainerStackMap(List<String> inputList) {
        Map<Integer, ArrayDeque<String>> containerStacks = new HashMap<>();

        for(String containerRow : inputList) {
            //We only want the rows with the container diagram for now.
            if(!containerRow.contains("["))
                break;

            AtomicInteger containerRowIndex = new AtomicInteger(0);
            Arrays.stream(containerRow.split(""))
                    //Because stacks are not equally high and therefore we cannot strip whitespace, we divide our row into columns of 4 characters (e.g. '[X] ')
                    .collect(Collectors.groupingBy(s -> containerRowIndex.getAndIncrement() / 4))
                    .entrySet().stream()
                    //Filter out any entries not containing a container
                    .filter(containerEntry -> containerEntry.getValue().get(1).matches("[A-Z]"))
                    //Add them to our ArrayDequeMap
                    .forEach(containerEntry -> {
                        if(containerStacks.containsKey(containerEntry.getKey()))
                            containerStacks.get(containerEntry.getKey()).addLast(containerEntry.getValue().get(1));
                        else
                            containerStacks.put(containerEntry.getKey(), new ArrayDeque<>(Collections.singleton(containerEntry.getValue().get(1))));
                    });
        }
        return containerStacks;
    }
}
