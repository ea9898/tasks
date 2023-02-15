package jm.four.four;

public class Car implements AutoCloseable {

    public void close() {
        System.out.println("Машина закрывается...");
    }

    public void drive() {
        System.out.println("Машина поехала.");
    }
}
