import java.util.Scanner;

public class LectureOne {
    public static void main(String args[]) {
        // this is the comments
        /*
         * this is a multi-line comment
         * yadda yadda yadda
         */

        int year;
        year = 2008;
        long b = 1000l;
        float f = 543f;
        System.out.println("What year were you born?");
        Scanner scan = new Scanner(System.in);
        year = scan.nextInt();
        int age = 2025 - year;
        System.out.println("You must be " + age);
        final int MAX = 100;
        // MAX = 235;
        final int MIN;
        MIN = 5;
        // MIN = 8;
    }

}