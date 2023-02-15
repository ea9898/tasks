package jm.four.seven;


import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {

    }

    public static void logging() {
        Logger logger = Logger.getLogger("com.javamentor.logging.Test");
        logger.log(Level.INFO, "Все хорошо");
        logger.log(Level.WARNING, "Произошла ошибка");
    }
}
