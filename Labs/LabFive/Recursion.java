import java.util.Arrays;

public class Recursion {

    public static String writeInReverse(int i) {
        // String answer = "";
        if (i / 10 == 0) {
            return i + " ";
        }
        return i % 10 + " " + writeInReverse(i / 10);
        // System.out.print(i % 10);
    }

    public static void WriteLine(Character c, int i) {
        if (i == 1) {
            System.out.print(c);
        } else {
            WriteLine(c, i - 1);
            System.out.print(c);
        }
    }

    public static void WriteBlock(Character c, int i, int j) {
        if (j == 1) {
            WriteLine(c, i);
            // System.out.println()
        } else {
            WriteBlock(c, i, j - 1);
            System.out.println();
            WriteLine(c, i);

        }
    }

    public static void printReverse(int[] a) {
        if (a.length == 1) {
            System.out.print(a[0] + " ");
        } else {

            printReverse(Arrays.copyOfRange(a, 1, a.length));
            System.out.print(a[0] + " ");
        }
    }

    public static void main(String args[]) {
        String answer1 = writeInReverse(527);
        System.out.println(answer1);

        WriteLine('*', 5);
        WriteBlock('*', 5, 3);
        int[] temp = { 1, 2, 3, 4 };
        printReverse(temp);
    }
}
