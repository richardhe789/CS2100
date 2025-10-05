public class TestIt {

    public static Animal var1 = new Dog("dog");
    public static Animal var2 = new Cow("cow");
    public static WorkingDogs var3 = new WorkingDogs("workdog");
    public static Dog var4 = new WorkingDog("workdog2");
    public static Cow var7 = new Cow("cow2");
    public static Snake var8 = new Snake("snake");
    public static Object var5 = new Cow("cow3"); // is-a relationship
    public static Object var6 = new Dog("dog2");

    public static void main(String args[]) {
        var1.testIt1(); // one-dog
        var2.testIt2(); // error - cow does not have a testit2 method
        var3.testIt1(); // one-workingdog
        var4.testIt1(); // one-workingdog
        var5.testIt3(); // error - object has no testit3 <- error
        var6.testIt1(); // error - object has no dog2
        var4.testIt2(); //
        var3.testIt3(); // working dog type
        var4.testIt3();
        ((Dog) var1).testIt2(); // one - dog
        ((Cow) var2).testIt2();
        ((Animal) var8).testIt1();
        var7 = var2;
        var7.testIt3();
        ((Cow) var2).testIt3();
    }
}