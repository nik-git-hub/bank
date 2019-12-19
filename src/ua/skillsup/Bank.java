package ua.skillsup;

import java.math.BigDecimal;
import static java.math.BigDecimal.ROUND_HALF_UP;

public class Bank {
    public static void main(String[] args) {

        AccountManager accountManager = new AccountManager();

        process(Transaction.REFILL, "100.00", accountManager);

        process(Transaction.TRANSFER, "200.000", accountManager);

        process(Transaction.REFILL, "20.000", accountManager);

        process(Transaction.REFILL, "5.0000", accountManager);

        process(Transaction.TRANSFER, "100.0000", accountManager);

        process(Transaction.TRANSFER, "3.0", accountManager);
    }

    private static void process(Transaction transaction, String amount, AccountManager accountManager){
        BigDecimal amountTrans = initAmountTrans(amount);
        accountManager.transaction(transaction, amountTrans);
        printAccountState(transaction, amountTrans, accountManager);
    }

    private static BigDecimal initAmountTrans(String amount) {
        return new BigDecimal(amount).setScale(2, ROUND_HALF_UP);
    }

    private static void printAccountState(Transaction transaction, BigDecimal amount, AccountManager accountManager){

        System.out.println("\n____Transaction " + transaction + ". Amount " + amount + ". State of accounts.");

        System.out.println("Refill account " + accountManager.getAccountRefill().getNumber()
                + ". Balance " + accountManager.getAccountRefill().getBalance());

        System.out.println("Transfer account " + accountManager.getAccountTransfer().getNumber()
                + ". Balance " + accountManager.getAccountTransfer().getBalance());
    }
}
