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

        // for loop
        for (int i = 0; i < 10; i++) {
            System.out.println("hello");
            System.out.println("hello");
        }

        int cookies = 5;
        while (cookies > 0) {
            System.out.println("Eating a cookie, " + cookies + " left.");
            cookies--;
        }

        cookies = 0;
        do {
            cookies++;
            System.out.println("Tried to eat a cookie, cookies = " + cookies);
            cookies--;
        } while (cookies > 0);

        String s1 = "abc";
        String s2 = "abc";

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

    }

    public static int add(int a, int b) {
        return a + b;
    }
}