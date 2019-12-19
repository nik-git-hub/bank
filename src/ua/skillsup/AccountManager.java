package ua.skillsup;

import java.math.BigDecimal;

public class AccountManager {

    private long accountNumber = 0;
    private Account accountRefill;
    private Account accountTransfer;

    public AccountManager(){
        accountNumber++;
        accountRefill = new Account(accountNumber, new BigDecimal("0") );
        accountNumber++;
        accountTransfer = new Account(accountNumber, new BigDecimal("0"));
    }

    public void transaction(Transaction transaction, BigDecimal amount){
        switch (transaction) {
            case REFILL: {
                refill(amount);
                break;
            }
            case TRANSFER: {
                transfer(amount);
                break;
            }
        }
    }

    private void refill(BigDecimal amount){
        accountRefill.setBalance((accountRefill.getBalance().add(amount)));
    }

    private void transfer(BigDecimal amount){
        if ( accountRefill.getBalance().compareTo(amount) < 0) {
            System.out.print("\nThe transaction is cancelled. There is no enough money.");
            return;
        }

        accountRefill.setBalance(accountRefill.getBalance().subtract(amount));
        accountTransfer.setBalance(accountTransfer.getBalance().add(amount));

    }

    public Account getAccountRefill() {
        return accountRefill;
    }

    public Account getAccountTransfer() {
        return accountTransfer;
    }

}
