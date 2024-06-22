package entity;

public class Account {
    private String accountNumber;
    private int balance;
    private String ifscCode;

    public Account(String accountNumber, int balance, String ifscCode) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.ifscCode = ifscCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }
}
