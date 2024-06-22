package service.amountWithdraw;

import entity.ATM;

public class TwoThousandWithdrawProcessor extends CashWithdrawProcessor{
    public TwoThousandWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor){
        super(nextCashWithdrawProcessor);
    }

    public void withdraw(ATM atm, int remainingAmount){

        int required =  remainingAmount/2000;
        int balance = remainingAmount%2000;

        System.out.println(required + " " + balance + " " + atm.getTwoThousandRupeesNote());

        if(required <= atm.getTwoThousandRupeesNote()) {
            atm.setTwoThousandRupeesNote(atm.getTwoThousandRupeesNote() - required);
        }
        else if(required > atm.getTwoThousandRupeesNote()) {
            balance = balance + (required-atm.getTwoThousandRupeesNote()) * 2000;
            atm.setTwoThousandRupeesNote(0);
        }
        if(balance != 0){
            super.withdraw(atm, balance);
        }
    }
}
