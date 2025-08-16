package org.example;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(data);
             ObjectInputStream ois = new ObjectInputStream(bais)) {

            int size = ois.readInt();
            if (size < 0) {
                throw new IllegalArgumentException("Array size cannot be negative");
            }

            Animal[] animals = new Animal[size];
            for (int i = 0; i < size; i++) {
                Object obj = ois.readObject();
                if (!(obj instanceof Animal)) {
                    throw new IllegalArgumentException("Element at index " + i + " is not an Animal");
                }
                animals[i] = (Animal) obj;
            }

            if (bais.available() > 0) {
                throw new IllegalArgumentException("Extra data after array elements");
            }

            return animals;
        } catch (IOException | ClassNotFoundException | NegativeArraySizeException e) {
            throw new IllegalArgumentException(e);
        }
    }
}