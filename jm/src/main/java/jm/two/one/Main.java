package jm.two.one;

public class Main {
    public static void main(String[] args) {
        System.out.println(doubleExpression(1, 2 , 3));
    }

    public static boolean doubleExpression(double a, double b, double c) {
        return Math.abs(a + b - c) < 0.0001;
    }
}
