package jm.four.four;

public class Main {
    public static void main(String[] args) {
        try(Car car = new Car()) {
            car.drive();
        } catch (RuntimeException e) {
            e.getStackTrace();
        }
    }
}
