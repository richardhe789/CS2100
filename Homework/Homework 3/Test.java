public class Test {
    int width, height;

    public Test(int w, int h) {
        this.width = w;
        this.height = h;
    }

    public void setHeight(int h1) {
        this.height = h1;
    }

    public String toString() {
        return "Width: " + width + " Height: " + height;
    }

    public static void main(String[] args) {
        Test rect1 = new Test(1, 5);
        Test rect2 = new Test(2, 6);

        System.out.println(rect1);
        System.out.println(rect2);
        rect1 = rect2;
        rect2.setHeight(20);
        System.out.println("------------");
        System.out.println(rect1);
        System.out.println(rect2);
    }
}
