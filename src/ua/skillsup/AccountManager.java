package ua.skillsup;

import java.math.BigDecimal;

public class AccountManager {

    private Account accountRefill;
    private Account accountTransfer;

    public AccountManager(){
        accountRefill = new Account(createAccountNumber(), new BigDecimal("0") );
        accountTransfer = new Account(createAccountNumber(), new BigDecimal("0"));
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

    private long createAccountNumber() {
        return System.currentTimeMillis();
    }

}
