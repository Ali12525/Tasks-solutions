package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int prevByte = -1;
        int currentByte;

        while ((currentByte = System.in.read()) != -1) {
            if (prevByte == '\r' && currentByte == '\n') {
                System.out.write('\n');
                prevByte = -1;
            } else {
                if (prevByte != -1) {
                    System.out.write(prevByte);
                }
                prevByte = currentByte;
            }
        }

        if (prevByte != -1) {
            System.out.write(prevByte);
        }

        System.out.flush();
    }
}