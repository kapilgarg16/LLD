package service.amountWithdraw;

import entity.ATM;
import exception.ATMException;
import exception.ErrorCode;

public class OneHundredWithdrawProcessor extends CashWithdrawProcessor{

    public OneHundredWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor){
        super(nextCashWithdrawProcessor);
    }

    public void withdraw(ATM atm, int remainingAmount){

        int required =  remainingAmount/100;
        int balance = remainingAmount%100;

        if(required <= atm.getHundredRupeesNote()) {
            atm.setHundredRupeesNote(atm.getHundredRupeesNote() - required);
        }
        else if(required > atm.getHundredRupeesNote()) {
            balance = balance + (required-atm.getHundredRupeesNote()) * 100;
            atm.setHundredRupeesNote(0);
        }
        if(balance != 0){
            throw new ATMException(ErrorCode.PUT_VALID_AMOUNT, "Ammount is not valid");
        }
    }
}
