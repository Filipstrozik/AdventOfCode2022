import java.util.Scanner;

public class Day2 {
    //ROCK A, X
    //PAPER B, Y
    //SCISSORS C, Z

    public static int totalScore(){
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            System.out.println(line);
            sum += getPointsOfRound2(line.charAt(0), line.charAt(2));
        }
        scanner.close();
        return sum;
    }

    public static int getPointsOfRound(char first, char sec){
        int sum = 0;
        switch (sec) {
            case 'X' -> sum += 1;
            case 'Y' -> sum += 2;
            case 'Z' -> sum += 3;
        }
        if(first == 'A' && sec == 'X'){
            sum += 3;
        } else if (first == 'A' && sec == 'Y'){
            sum += 6;
        } else if (first == 'A' && sec == 'Z'){
            sum += 0;
        } else if(first == 'B' && sec == 'X'){
            sum += 0;
        } else if (first == 'B' && sec == 'Y'){
            sum += 3;
        } else if (first == 'B' && sec == 'Z'){
            sum += 6;
        } else if(first == 'C' && sec == 'X'){
            sum += 6;
        } else if (first == 'C' && sec == 'Y'){
            sum += 0;
        } else if (first == 'C' && sec == 'Z'){
            sum += 3;
        }
        return sum;
    }

    public static int getPointsOfRound2(char first, char sec){
        int sum = 0;
        //X lose
        //Y draw
        //Z win
        switch (sec) {
            case 'X' -> sum += 0;
            case 'Y' -> sum += 3;
            case 'Z' -> sum += 6;
        }
        if(first == 'A' && sec == 'X'){
            sum += 3;
        } else if (first == 'A' && sec == 'Y'){
            sum += 1;
        } else if (first == 'A' && sec == 'Z'){
            sum += 2;
        } else if(first == 'B' && sec == 'X'){
            sum += 1;
        } else if (first == 'B' && sec == 'Y'){
            sum += 2;
        } else if (first == 'B' && sec == 'Z'){
            sum += 3;
        } else if(first == 'C' && sec == 'X'){
            sum += 2;
        } else if (first == 'C' && sec == 'Y'){
            sum += 3;
        } else if (first == 'C' && sec == 'Z'){
            sum += 1;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(totalScore());
    }
}
