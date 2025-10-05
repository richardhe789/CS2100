public class Main {
    private static Animal a;
    private static Cow c = new Cow("Bossy");
    private static Dog d = new Dog("Rover");
    private static Snake s = new Snake("Ernie");
    private static WorkingDogs w = new WorkingDogs("Collie");
    private static Animal[] farm = new Animal[4];

    //
    public static void main(String args[]) { // the noises are different because the Animal is abstract so it looks at
                                             // the extending class (cow, dog, snake) for the speak method.
        // a = c;
        // a.speak(); // makes cow noise
        // a = d;
        // a.speak(); // makes dog noise
        // a = s;
        // a.speak(); // makes snake noise

        farm[0] = c;
        farm[1] = d;
        farm[2] = s;
        farm[3] = w; // this doesn't work -"Working cannot be resolved to a type"

        for (int i = 0; i < farm.length; i++) {
            farm[i].speak();
            System.out.println("----");
            farm[i].toString(); // this doesn't print. or, nothing happens here.
            if (farm[i] instanceof WorkingDogs) { // check if the selected animal is a working dog
                WorkingDogs temp = (WorkingDogs) farm[i]; // must cast it for the animal to use working dog methods

                temp.work(); // this doesn't work either

            }
        }

    }
}