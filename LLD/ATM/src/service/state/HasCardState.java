package service.state;
import entity.ATM;
import entity.Card;
import entity.TransactionType;
import exception.ATMException;
import exception.ErrorCode;
import service.ATMState;

public class HasCardState extends ATMState{
    @Override
    public void insertCard(ATM atm, Card card) throws ATMException {
        throw new ATMException(ErrorCode.SOME_THING_WENT_WRONG, "SOME_THING_WENT_WRONG");
    }

    @Override
    public void authenticatePin(ATM atm, Card card, String pin) throws ATMException {
        if(card.getPinNumber().equals(pin)){
            atm.setCurrentState(new SelectOperationState());
        }
        else{
            throw new ATMException(ErrorCode.PINCODE_MISMATCH, "pincode is not valid");
        }
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
