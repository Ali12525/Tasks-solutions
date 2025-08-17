package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextLine()) {
            return;
        }

        String line = scanner.nextLine().trim();
        if (line.isEmpty()) {
            return;
        }

        String[] tokens = line.split("\\s+");

        List<Integer> result = new ArrayList<>();

        for (int i = 1; i < tokens.length; i += 2) {
            result.add(Integer.parseInt(tokens[i]));
        }

        for (int i = result.size() - 1; i >= 0; i--) {
            System.out.print(result.get(i));
            if (i > 0) {
                System.out.print(" ");
            }
        }
    }
}
