package jm.four.three;

import jm.four.three.exception.BadCreditHistoryException;
import jm.four.three.exception.ProblemWithLawException;
import jm.four.three.interfases.BankWorker;

public class Main {
    public static void main(String[] args) {
        BankClient client1 = new BankClient("Good");
        BankClient client2 = new BankClient("Проблемы с законом");
        BankClient client3 = new BankClient("Проблемы с банковской историей");
        BankWorker rabotnik = new BankRabotnik();

        System.out.println(getCreditForClient(rabotnik, client1) + "\n"); //true
        System.out.println(getCreditForClient(rabotnik, client2) + "\n"); //false
        System.out.println(getCreditForClient(rabotnik, client3) + "\n"); // "Проблемы с банковской историей" false
    }

    public static boolean getCreditForClient(BankWorker bankWorker, BankClient bankClient) {
        try {
            return bankWorker.checkClientForCredit(bankClient);
        } catch (BadCreditHistoryException e) {
            System.out.println("Проблемы с банковской историей");
            return false;
        } catch (ProblemWithLawException e) {
            return false;
        }
    }
}
