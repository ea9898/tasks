package jm.three.three;

public class Main {
    public static void main(String[] args) {
        moveRobot(new Robot(1, 10, Direction.UP), 10, 2);
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        while (robot.getX() > toX) {
            if (robot.getDirection() != Direction.LEFT) {
                robot.turnLeft();
            } else if (robot.getDirection() == Direction.LEFT) {
                robot.stepForward();
            }
        }

        while (toX > robot.getX()) {
            if (robot.getDirection() != Direction.RIGHT) {
                robot.turnRight();
            } else if (robot.getDirection() == Direction.RIGHT) {
                robot.stepForward();
            }
        }

        while (robot.getY() > toY) {
            if (robot.getDirection() != Direction.DOWN) {
                robot.turnLeft();
            } else if (robot.getDirection() == Direction.DOWN) {
                robot.stepForward();
            }
        }

        while (toY > robot.getY()) {
            if (robot.getDirection() != Direction.UP) {
                robot.turnLeft();
            } else if (robot.getDirection() == Direction.UP) {
                robot.stepForward();
            }
        }
    }
}

