package org.example;

public class AsciiCharSequence implements CharSequence {
    private final byte[] data;

    public AsciiCharSequence(byte[] data) {
        this.data = data.clone();
    }

    @Override
    public int length() {
        return data.length;
    }

    @Override
    public char charAt(int index) {
        return (char) (data[index] & 0xFF);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        byte[] subArray = new byte[end - start];
        System.arraycopy(data, start, subArray, 0, end - start);
        return new AsciiCharSequence(subArray);
    }

    @Override
    public String toString() {
        return new String(data);
    }
}