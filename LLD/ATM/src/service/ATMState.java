package service;
import entity.ATM;
import entity.Card;
import entity.TransactionType;
import exception.ATMException;

public abstract class ATMState {
 abstract public void insertCard(ATM atm, Card card) throws ATMException;
 abstract public void authenticatePin(ATM atm, Card card, String pin) throws ATMException;
 abstract public void selectOperation(ATM atm, Card card, TransactionType transactionType) throws ATMException;
 abstract public void cashWithdrawl(ATM atm, Card card, int withdrawAmount) throws ATMException;
 abstract public void checkBalance(ATM atm, Card card) throws ATMException;
 abstract public void exit(ATM atm) throws ATMException;
}
