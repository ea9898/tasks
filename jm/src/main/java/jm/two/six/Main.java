package jm.two.six;

public class Main {

    public static void main(String[] args) {
        System.out.println(factorial(3));
    }

    public static int factorial(int f) {
        int n = 1;

        for (int i = 2; i <= f; i++) {
            n *= i;
        }

        return n;
    }
}
