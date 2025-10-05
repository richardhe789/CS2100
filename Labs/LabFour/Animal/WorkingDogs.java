
public class WorkingDogs extends Dog implements Working {
    public WorkingDogs(String nme) {
        super(nme);
    }

    public void work() {
        super.speak();
        System.out.println("I can herd sheep and cows");
    }

    public void testIt1() {
        System.out.println("One-WorkingDog");
    }

    public void testIt3() {
        System.out.println("Three-WorkingDog");
    }
}