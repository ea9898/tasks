package jm.two.nine;

public class Main {
    public static void main(String[] args) {
        printOddNumbers(new int[]{1, 2, 3, 4, 5});
    }

    public static void printOddNumbers(int[] arr) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                sb.append(arr[i]).append(",");
            }
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);

    }
}
