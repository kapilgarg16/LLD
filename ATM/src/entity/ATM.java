package entity;

import service.ATMState;
import service.state.IdleState;


public class ATM {
    private static ATM atm;   //singleton classes
    private int balance;
    private int hundredRupeesNote;
    private int fiveHundredRupeesNote;
    private int twoThousandRupeesNote;
    private ATMState atmState;

    private ATM(){
        balance = 0;
        hundredRupeesNote = 0;
        fiveHundredRupeesNote = 0;
        twoThousandRupeesNote = 0;
    }

    public static ATM getObject(){
        if(atm == null){
            atm = new ATM();
            atm.setCurrentState(new IdleState());
        }
        return atm;
    }

    public void setATMBalance(int balance, int hundredRupeesNote, int fiveHundredRupeesNote, int twoThousandRupeesNote){
        this.balance += balance;
        this.hundredRupeesNote += hundredRupeesNote;
        this.fiveHundredRupeesNote += fiveHundredRupeesNote;
        this.twoThousandRupeesNote += twoThousandRupeesNote;
    }
    public void setBalance(int balance){
        this.balance = balance;
    }
    public int getBalance(){
        return balance;
    }

    public int getFiveHundredRupeesNote() {
        return fiveHundredRupeesNote;
    }

    public int getTwoThousandRupeesNote() {
        return twoThousandRupeesNote;
    }
    public int getHundredRupeesNote(){
        return hundredRupeesNote;
    }

    public void setHundredRupeesNote(int hundredRupeesNote) {
        this.hundredRupeesNote = hundredRupeesNote;
    }

    public void setFiveHundredRupeesNote(int fiveHundredRupeesNote) {
        this.fiveHundredRupeesNote = fiveHundredRupeesNote;
    }

    public void setTwoThousandRupeesNote(int twoThousandRupeesNote) {
        this.twoThousandRupeesNote = twoThousandRupeesNote;
    }

    public ATMState getCurrentState(){
        return atmState;
    }
    public void setCurrentState(ATMState atmState){
        this.atmState = atmState;
    }

    public void printCurrentATMStatus(){
        System.out.println("Balance: " + balance);
        System.out.println("2kNotes: " + twoThousandRupeesNote);
        System.out.println("500Notes: " + fiveHundredRupeesNote);
        System.out.println("100Notes: " + hundredRupeesNote);
    }
}
