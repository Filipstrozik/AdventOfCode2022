import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


//pytania


/*
* jak bardzo marka osobista wpływa na rynek, czy w jakiś sposob ogranicza wolnosc człowieka? Elon musk
* jak sam ty świadomie użyłeś marki osobistej do sowjej prezentacji
*
* */
public class Day3 {

    public static int totalPrioritySum(){
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int len = line.length();
            System.out.println(line);
            String firstChamber = line.substring(0, len / 2);
            String secondChamber = line.substring(len / 2, len);
            System.out.println(firstChamber);
            System.out.println(secondChamber);

            List<Character> s1 = new ArrayList<>();
            List<Character> s2 = new ArrayList<>();

            for (int i = 0; i < firstChamber.length(); i++) {
                s1.add(firstChamber.charAt(i));
            }

            for (int i = 0; i < secondChamber.length(); i++) {
                s2.add(secondChamber.charAt(i));
            }
            s1.retainAll(s2);
            System.out.println(s1.get(0));
            int temp = (int) s1.get(0);
            if(temp <= (int) 'Z'){
                temp -= 38;
            } else {
                temp -= 96;
            }
            sum+=temp;
            System.out.println(temp);
        }
        scanner.close();
        return sum;
    }

    public static int totalPrioritySum2(){
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int index = 0;
        while (scanner.hasNextLine()) {
            String firstChamber = scanner.nextLine();
            String secondChamber = scanner.nextLine();
            String thirdBack = scanner.nextLine();

            List<Character> s1 = new ArrayList<>();
            List<Character> s2 = new ArrayList<>();
            List<Character> s3 = new ArrayList<>();

            for (int i = 0; i < firstChamber.length(); i++) {
                s1.add(firstChamber.charAt(i));
            }

            for (int i = 0; i < secondChamber.length(); i++) {
                s2.add(secondChamber.charAt(i));
            }

            for (int i = 0; i < thirdBack.length(); i++) {
                s3.add(thirdBack.charAt(i));
            }

            s1.retainAll(s2);
            s1.retainAll(s3);

            System.out.println(s1.get(0));
            int temp = (int) s1.get(0);
            if(temp <= (int) 'Z'){
                temp -= 38;
            } else {
                temp -= 96;
            }
            sum+=temp;
            System.out.println(temp);
        }
        scanner.close();
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(totalPrioritySum2());
    }
}
