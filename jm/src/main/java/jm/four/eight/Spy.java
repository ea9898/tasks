package jm.four.eight;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Spy implements MailService {
    private Logger logger;

    public Spy(Logger logger) {
        this.logger = logger;
    }


    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailService) {
            MailMessage mailMessage = (MailMessage) mail;
            if (mailMessage.getFrom().contains("Austin Powers") || mailMessage.to.contains("Austin Powers")) {
                this.logger.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"",
                        new Object[]{mailMessage.getFrom(), mailMessage.getTo(), mailMessage.getMessage()});
            } else {
                logger.log(Level.INFO, "Usual correspondence: from {0} to {1}",
                        new Object[]{mailMessage.getFrom(), mailMessage.getTo()});
            }
        }

        return mail;
    }
}
