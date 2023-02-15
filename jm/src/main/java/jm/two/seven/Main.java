package jm.two.seven;

public class Main {

    public static void main(String[] args) {
        System.out.println(factorial(3));
    }

    public static int factorial(int f) {

        if (f == 0 || f == 1) {
            return 1;
        }

        return  factorial(f - 1) * f;

    }
}
