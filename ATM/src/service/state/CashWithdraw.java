package service.state;

import entity.ATM;
import entity.Card;
import entity.TransactionType;
import exception.ATMException;
import exception.ErrorCode;
import service.ATMState;
import service.amountWithdraw.CashWithdrawProcessor;
import service.amountWithdraw.FiveHundredWithdrawProcessor;
import service.amountWithdraw.OneHundredWithdrawProcessor;
import service.amountWithdraw.TwoThousandWithdrawProcessor;

public class CashWithdraw extends ATMState {
    @Override
    public void insertCard(ATM atm, Card card) throws ATMException {
        throw new ATMException(ErrorCode.SOME_THING_WENT_WRONG, "SOME_THING_WENT_WRONG");
    }

    @Override
    public void authenticatePin(ATM atm, Card card, String pin) throws ATMException {
        throw new ATMException(ErrorCode.SOME_THING_WENT_WRONG, "SOME_THING_WENT_WRONG");
    }

    @Override
    public void selectOperation(ATM atm, Card card, TransactionType transactionType) throws ATMException {
        throw new ATMException(ErrorCode.SOME_THING_WENT_WRONG, "SOME_THING_WENT_WRONG");
    }

    @Override
    public void cashWithdrawl(ATM atm, Card card, int withdrawAmount) throws ATMException {
        if (atm.getBalance() < withdrawAmount) {
            atm.setCurrentState(new IdleState());
            throw new ATMException(ErrorCode.INSUFFICIENT_BALANCE, "Insufficient fund in the ATM Machine");
        } else if (card.getAccount().getBalance() < withdrawAmount) {
            atm.setCurrentState(new IdleState());
            throw new ATMException(ErrorCode.INSUFFICIENT_BALANCE, "Insufficient fund in the your Bank Account");
        } else {
            card.getAccount().setBalance(card.getAccount().getBalance() - withdrawAmount);
            atm.setBalance(atm.getBalance() - withdrawAmount);
            //using chain of responsibility for this logic, how many 2k Rs notes, how many 500 Rs notes etc, has to be withdrawal
            CashWithdrawProcessor withdrawProcessor =
                    new TwoThousandWithdrawProcessor(new FiveHundredWithdrawProcessor(new OneHundredWithdrawProcessor(null)));
            withdrawProcessor.withdraw(atm, withdrawAmount);
            exit(atm);
        }
    }
    @Override
    public void checkBalance(ATM atm, Card card) throws ATMException {
        throw new ATMException(ErrorCode.SOME_THING_WENT_WRONG, "SOME_THING_WENT_WRONG");
    }

    @Override
    public void exit(ATM atm) throws ATMException {
        System.out.println("Exit happen, Please collect your card");
    }
}
