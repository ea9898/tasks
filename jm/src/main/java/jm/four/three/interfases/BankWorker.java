package jm.four.three.interfases;

import jm.four.three.BankClient;
import jm.four.three.exception.BadCreditHistoryException;
import jm.four.three.exception.ProblemWithLawException;

public interface BankWorker {

    boolean checkClientForCredit(BankClient bankClient) throws BadCreditHistoryException, ProblemWithLawException;
}

