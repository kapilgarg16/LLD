package service.state;
import entity.ATM;
import entity.Card;
import entity.TransactionType;
import exception.ATMException;
import exception.ErrorCode;
import service.ATMState;

public class IdleState extends ATMState{
    @Override
    public void insertCard(ATM atm, Card card) throws ATMException {
        System.out.println("Card is inserted");
        atm.setCurrentState(new HasCardState());
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
        throw new ATMException(ErrorCode.SOME_THING_WENT_WRONG, "SOME_THING_WENT_WRONG");
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
