public class Main {
    public static void main(String[] args) {
        Animal a = new Animal();

        Dog d = new Dog();
        a.getFlyType(d);

        Bird b = new Bird();
        a.getFlyType(b);

        Cat c = new Cat();
        a.getFlyType(c);
    }
}