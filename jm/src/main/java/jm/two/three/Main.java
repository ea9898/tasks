package jm.two.three;

public class Main {
    public static void main(String[] args) {
        System.out.println(charExpression(111));
    }

    public static char charExpression(int a) {
        return (char) ('\\' + a);
    }
}
