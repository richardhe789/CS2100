public class LectureTwo {
    public static void main(String args[]) {
        int x = 5;
        int y = 10;
        int sum = x + y;
        int sum2 = add(x, y);
        int num1 = 3;
        int num2 = 5;
        int sum3 = add(num1, num2);
        System.out.println(sum);
        System.out.println(sum2);
        System.out.println(sum3);

        // if-else
        int temperature = 68;
        if (temperature > 70) {
            System.out.println("Wear shorts and a tank top");
        } else if (temperature > 50) {
            System.out.println("Wear a t-shirt");
        } else if (temperature > 25) {
            System.out.println("Wear coat");
        } else {
            System.out.println("Wear heavy coat");
        }

        // Dangling else
        if (temperature > 70)
            if (temperature > 50)
                System.out.println("billy bob boe");
        if (temperature > 30)
            System.out.println("Wear xxxx");
        else {
            System.out.println("Wear Heavy Coat");
        }

        if (temperature > 70) {
            if (temperature > 50) {
                System.out.println("xxxx");
            } else
                System.out.println("yyyyy");
        } else {
            System.out.println("zzzzz");
        }

        // switch statement
        char grade = 'A';

        switch (grade) {
            case 'A':
                System.out.println("Your grade: A");
                break;
            case 'B':
                System.out.println("Your grade: B");
                break;
            case 'C':
            case 'D':
                System.out.println("Your grade: other");
                break;
            default:
                System.out.println("Failed");
        }

        ///////
        // if (x && y) {
        // System.out.println("and!");
        // }
    }

    public static int add(int a, int b) {
        return a + b;
    }
}