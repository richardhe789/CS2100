public class Dog extends Animal {
    public Dog(String nm) {
        super(nm); // builds ala parent
    }

    public void speak() { // this method specific to Dog
        System.out.println("Arf Arf");
    }

    public void testIt2() {
        System.out.println("Two-Dog");
    }
}
