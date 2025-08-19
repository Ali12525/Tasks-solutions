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

    public static void moveRobot(Robot robot, int toX, int toY) {
        int dx = toX - robot.getX();
        if (dx != 0) {
            Direction desiredDirection = (dx > 0) ? Direction.RIGHT : Direction.LEFT;

            turnRobot(robot, desiredDirection);

            for (int i = 0; i < Math.abs(dx); i++) {
                robot.stepForward();
            }
        }

        int dy = toY - robot.getY();
        if (dy != 0) {
            Direction desiredDirection = (dy > 0) ? Direction.UP : Direction.DOWN;

            turnRobot(robot, desiredDirection);

            for (int i = 0; i < Math.abs(dy); i++) {
                robot.stepForward();
            }
        }
    }

    private static void turnRobot(Robot robot, Direction desiredDirection) {
        while (robot.getDirection() != desiredDirection) {
            if (shouldTurnRight(robot.getDirection(), desiredDirection)) {
                robot.turnRight();
            } else {
                robot.turnLeft();
            }
        }
    }

    private static boolean shouldTurnRight(Direction current, Direction desired) {
        switch (current) {
            case UP: return desired == Direction.RIGHT;
            case RIGHT: return desired == Direction.DOWN;
            case DOWN: return desired == Direction.LEFT;
            case LEFT: return desired == Direction.UP;
            default: return false;
        }
    }

    public class Robot {

        public Direction getDirection() {
            // текущее направление взгляда
        }

        public int getX() {
            // текущая координата X
        }

        public int getY() {
            // текущая координата Y
        }

        public void turnLeft() {
            // повернуться на 90 градусов против часовой стрелки
        }

        public void turnRight() {
            // повернуться на 90 градусов по часовой стрелке
        }

        public void stepForward() {
            // шаг в направлении взгляда
            // за один шаг робот изменяет одну свою координату на единицу
        }
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }
}