package Days;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1_1 {


    public static int findMostCalories(){
        int max = Integer.MIN_VALUE;
        try {
            File day1_1Input = new File("src/input1_1.txt");
            Scanner scanner = new Scanner(day1_1Input);
            int tempSum = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(line.length() != 0){
                    tempSum += Integer.parseInt(line);
                } else {
                    if(max < tempSum) max = tempSum;
                    tempSum = 0;
                }
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("No such a file");
            e.printStackTrace();
        }

        return max;
    }

    public static int findMostCaloriesTwo(){
        int max = Integer.MIN_VALUE;
        int maxSecond = Integer.MIN_VALUE;
        int maxThird = Integer.MIN_VALUE;
        try {
            File day1_1Input = new File("src/input1_1.txt");
            Scanner scanner = new Scanner(day1_1Input);
            int tempSum = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(line.length() != 0){
                    tempSum += Integer.parseInt(line);
                } else {
                    if(max < tempSum){
                        maxSecond = max;
                        max = tempSum;
                    }
                    else if(tempSum > maxSecond && tempSum < max){
                        maxThird = maxSecond;
                        maxSecond = tempSum;
                    }
                    else if(maxThird < tempSum && tempSum < maxSecond){
                        maxThird = tempSum;
                    }
                    tempSum = 0;
                }
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("No such a file");
            e.printStackTrace();
        }

        return max + maxSecond + maxThird;
    }

    public static void main(String[] args) {
        System.out.println(findMostCaloriesTwo());
    }
}
