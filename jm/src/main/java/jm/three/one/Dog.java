package jm.three.one;

public class Dog {
    public void sayHello() {
        System.out.println("Гав!");
    }

    public  void catchCat(Cat cat) {
        System.out.println("Кошка поймана");
        sayHello();
        cat.sayHello();
    }
}
