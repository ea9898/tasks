package jm.four.five;

import jm.four.five.exceptions.RobotConnectionException;
import jm.four.five.interfaceses.RobotConnection;
import jm.four.five.interfaceses.RobotConnectionManager;

public class Main {
    public static void main(String[] args) {

    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        RobotConnection robotConnection = null;

        for (int i = 0; i < 3; i++) {
            try {
                robotConnection = robotConnectionManager.getConnection();
                robotConnection.moveRobotTo(toX, toY);
                break;
            } catch (RobotConnectionException e) {
                if (i == 2) {
                    throw new RobotConnectionException(e.getMessage());
                }
            } finally {
                if (robotConnection != null) {
                    try {
                        robotConnection.close();
                    } catch (RobotConnectionException e) {
                        e.getStackTrace();
                    }
                }

            }
        }
    }
}


