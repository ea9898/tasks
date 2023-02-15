package jm.two.two;

public class Main {
    public static void main(String[] args) {
        System.out.println(drawisMonitorsCounter(3, 10));
    }

    public static int drawisMonitorsCounter(int monitors, int programmers) {
        return programmers % monitors;
    }
}
