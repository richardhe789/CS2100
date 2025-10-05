public class LectureThree {
    public static void main(String args[]) {
        int a = 3;
        int b = 4;
        int c = add(a, b);
        float d = 314;
        float e = 316;
        float f = add(c, d);
    }

    public static int add(int x, int y) {
        return x + y;
    }

    public static float add(float x, float y) {
        return x + y;
    }

    void changeInt(int x) {
        x = 18;
    }
}