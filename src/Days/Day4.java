package Days;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day4 {


    public static int howManyPairs() {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        while (scanner.hasNextLine()) {
            String[] elves = scanner.nextLine().split(",");
            String[] firstElf = elves[0].split("-");
            String[] secElf = elves[1].split("-");
//            System.out.println(firstElf[0]);
//            System.out.println(firstElf[1]);
//            System.out.println(secElf[0]);
//            System.out.println(secElf[1]);

            if (
                    Integer.parseInt(firstElf[0]) <= Integer.parseInt(secElf[0])
                            &&  Integer.parseInt(firstElf[1]) >=  Integer.parseInt(secElf[1])
                    ||  Integer.parseInt(firstElf[0]) >= Integer.parseInt(secElf[0])
                            &&  Integer.parseInt(firstElf[1]) <=  Integer.parseInt(secElf[1])
            ) {
                sum++;
            }
        }
        scanner.close();
        return sum;
    }

    public static int howManyPairs2() {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        while (scanner.hasNextLine()) {
            String[] elves = scanner.nextLine().split(",");
            String[] firstElf = elves[0].split("-");
            String[] secElf = elves[1].split("-");


            if (
                    Integer.parseInt(firstElf[1]) >= Integer.parseInt(secElf[0])
                            &&
                            Integer.parseInt(firstElf[0]) <= Integer.parseInt(secElf[1])
                    || Integer.parseInt(secElf[1]) >= Integer.parseInt(firstElf[0])
                    && Integer.parseInt(secElf[0]) <= Integer.parseInt(firstElf[1])
            ) {
                System.out.print(firstElf[0]);
                System.out.print("-");
                System.out.print(firstElf[1]);
                System.out.print(",");
                System.out.print(secElf[0]);
                System.out.print("-");
                System.out.println(secElf[1]);
                sum++;
            }
        }
        scanner.close();
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(howManyPairs2());
    }
}
