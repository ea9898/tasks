package jm.four.three;

import jm.four.three.exception.BadCreditHistoryException;
import jm.four.three.exception.ProblemWithLawException;
import jm.four.three.interfases.BankWorker;

public class BankRabotnik implements BankWorker {
    @Override
    public boolean checkClientForCredit(BankClient bankClient) throws BadCreditHistoryException, ProblemWithLawException {
        if (bankClient.status.equals("Проблемы с банковской историей")) {
            throw new BadCreditHistoryException();
        } else if (bankClient.status.equals("Проблемы с законом")) {
            throw new ProblemWithLawException();
        }
        return true;
    }
}

