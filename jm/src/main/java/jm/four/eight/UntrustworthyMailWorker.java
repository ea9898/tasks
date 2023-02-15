package jm.four.eight;

public class UntrustworthyMailWorker implements MailService {
    private MailService[] mailServices;
    private RealMailService realMailService;

    public UntrustworthyMailWorker(MailService[] mailServices, RealMailService realMailService) {
        this.mailServices = mailServices;
        this.realMailService = realMailService;
    }

    @Override
    public Sendable processMail(Sendable mail) {

        for (int i = 0; i < mailServices.length; i++) {
            mail = mailServices[i].processMail(mail);
        }
        return realMailService.processMail(mail);
    }

    public RealMailService getRealMailService() {
        return this.realMailService;
    }

    public MailService[] getMailServices() {
        return mailServices;
    }

    public void setMailServices(MailService[] mailServices) {
        this.mailServices = mailServices;
    }
}
