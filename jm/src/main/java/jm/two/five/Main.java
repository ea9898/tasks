package jm.two.five;

public class Main {
    public static void main(String[] args) {
        System.out.println(isPalindrome("Was it a cat I saw"));
    }

    public static boolean isPalindrome(String text) {
        return new StringBuilder(text.replaceAll("[^A-Za-zА-Яа-я0-9]", "")).reverse().toString().equalsIgnoreCase(text.replaceAll("[^A-Za-zА-Яа-я0-9]", ""));
    }
}
