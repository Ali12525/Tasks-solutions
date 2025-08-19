package org.example;

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

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        final int MAX_ATTEMPTS = 3;

        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            RobotConnection connection = null;
            try {
                connection = robotConnectionManager.getConnection();
                connection.moveRobotTo(toX, toY);
                return;
            } catch (RobotConnectionException e) {
                if (attempt == MAX_ATTEMPTS) {
                    throw e;
                }
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Exception ignored) {}
                }
            }
        }
    }
}

