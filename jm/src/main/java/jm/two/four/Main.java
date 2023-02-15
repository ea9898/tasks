package jm.two.four;

public class Main {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(3));
    }

    public static boolean isPowerOfTwo(int n) {
        return Integer.bitCount(Math.abs(n)) == 1;
    }
}
