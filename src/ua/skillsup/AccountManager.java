package ua.skillsup;

import java.math.BigDecimal;

public class AccountManager {

    private long accountNumber = 0;
    private Account accountRefill;
    private Account accountTransfer;

    public AccountManager(){
        accountRefill = new Account(++accountNumber);
        accountTransfer = new Account(++accountNumber);
    }

    public void trans (TransactionEnum transaction, BigDecimal amount){
        switch (transaction) {
            case REFILL:
                refill(amount);
                break;
            case TRANSFER:
                transfer(amount);
        }
    }

    private void refill(BigDecimal amount){
        accountRefill.setBalance((accountRefill.getBalance().add(amount)));
    }

    private void transfer(BigDecimal amount){
        if ( accountRefill.getBalance().compareTo(amount) >= 0) {
            accountRefill.setBalance(accountRefill.getBalance().subtract(amount));
            accountTransfer.setBalance(accountTransfer.getBalance().add(amount));
        } else {
            System.out.print("\nThe transaction is cancelled. There is no enough money.");
        }
    }

    public Account getAccountRefill() {
        return accountRefill;
    }

    public Account getAccountTransfer() {
        return accountTransfer;
    }

}
