package jm.three.five;

import java.util.Arrays;

public class AsciiCharSequence implements CharSequence {

    private final byte[] myArr;

    public AsciiCharSequence(byte[] myArr) {
        this.myArr = myArr;
    }

    @Override
    public int length() {
        return toString().length();
    }

    @Override
    public char charAt(int index) {
        return toString().charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new AsciiCharSequence(Arrays.copyOfRange(myArr, start, end));
    }

    @Override
    public String toString() {
        return new String(myArr);
    }
}
