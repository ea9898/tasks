package jm.four.eight;

public class Thief implements MailService {

    private int minPrice = 0;

    public Thief(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getStolenValue(int sum) {


        return sum;
    }

    @Override
    public Sendable processMail(Sendable mail) {



        return null;
    }
}
