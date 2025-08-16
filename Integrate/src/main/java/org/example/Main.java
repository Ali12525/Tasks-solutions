package org.example;

import java.util.function.DoubleUnaryOperator;

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

    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double step = 1e-6;
        double integral = 0.0;
        double currentX = a;

        while (currentX < b) {
            double nextX = Math.min(currentX + step, b);
            double delta = nextX - currentX;
            integral += f.applyAsDouble(currentX) * delta;
            currentX = nextX;
        }

        return integral;
    }
}