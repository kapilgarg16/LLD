package service.amountWithdraw;

import entity.ATM;

public class FiveHundredWithdrawProcessor extends CashWithdrawProcessor{

    public FiveHundredWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor){
        super(nextCashWithdrawProcessor);
    }

    public void withdraw(ATM atm, int remainingAmount){
        int required =  remainingAmount/500;
        int balance = remainingAmount%500;

        if(required <= atm.getFiveHundredRupeesNote()) {
            atm.setFiveHundredRupeesNote(atm.getFiveHundredRupeesNote() - required);
        }
        else if(required > atm.getFiveHundredRupeesNote()) {
            balance = balance + (required-atm.getFiveHundredRupeesNote()) * 500;
            atm.setFiveHundredRupeesNote(0);
        }
        if(balance != 0){
            super.withdraw(atm, balance);
        }
    }
}

