import entity.*;
import exception.ATMException;
import service.state.IdleState;

import static entity.ATM.getObject;

public class ATMRoom {
    private User user;
    private ATM atm;
    public static void main(String[] args) {
        ATMRoom atmRoom = new ATMRoom();
        atmRoom.initialize();

        ATM atm = atmRoom.getAtm();
        Card card = atmRoom.getUser().getCard();

        try{
            atm.printCurrentATMStatus();
            atm.getCurrentState().insertCard(atm, card);
            atm.getCurrentState().authenticatePin(atm, card, "328022");
            atm.getCurrentState().selectOperation(atm, card, TransactionType.WITHDRAWL);
            atm.getCurrentState().cashWithdrawl(atm, card, 4001);
            atm.printCurrentATMStatus();
        }
        catch (ATMException e){
            atm.setCurrentState(new IdleState());
            atm.getCurrentState().exit(atm);
            System.out.println(e.getErrorCode()+ " " + e.getMsg());
        }
    }

    public void initialize(){
        atm = getObject();
        atm.setATMBalance(5000, 10, 4, 1);
        user = createUser();
    }

    public User createUser(){
        User user = new User(1, createCard());
        return user;
    }

    public Card createCard(){
        Card card = new Card("Kapil", 1234, "012","03/12", "328022", createAccount());
        return card;
    }

    public Account createAccount() {
        Account account = new Account("12334", 5000, "PNBXYZ");
        return account;
    }

    public User getUser(){
        return user;
    }

    public ATM getAtm(){
        return atm;
    }
}
