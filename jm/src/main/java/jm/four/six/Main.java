package jm.four.six;

import jm.four.six.exceptions.RobotConnectionException;
import jm.four.six.interfaceses.RobotConnection;
import jm.four.six.interfaceses.RobotConnectionManager;

public class Main {
    public static void main(String[] args) {
    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        boolean connection = false;

        for (int i = 0; !connection && i < 3; i++) {
            try (RobotConnection robotConnection = robotConnectionManager.getConnection()) {
                robotConnection.moveRobotTo(toX, toY);
                connection = true;
            } catch (RobotConnectionException ignored) {

            }
        }
        if (!connection) {
            throw new RobotConnectionException("");
        }
    }
}


