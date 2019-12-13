package ua.skillsup;

import java.math.BigDecimal;
import static java.math.BigDecimal.ROUND_HALF_UP;

public class Bank {
    public static void main(String[] args) {

        AccountManager accountManager = new AccountManager();

        TransactionEnum transaction;
        String  amount;

        transaction = TransactionEnum.REFILL;
        amount = "100.00";
        process(transaction, amount, accountManager);

        transaction = TransactionEnum.TRANSFER;
        amount = "200.000";
        process(transaction, amount, accountManager);

        transaction = TransactionEnum.REFILL;
        amount = "20.000";
        process(transaction, amount, accountManager);

        transaction = TransactionEnum.REFILL;
        amount = "5.0000";
        process(transaction, amount, accountManager);

        transaction = TransactionEnum.TRANSFER;
        amount = "100.0000";
        process(transaction, amount, accountManager);

        transaction = TransactionEnum.TRANSFER;
        amount = "3.0";
        process(transaction, amount, accountManager);
    }

    private static void process(TransactionEnum transaction, String amount, AccountManager accountManager){
        BigDecimal amountTrans = initAmountTrans(amount);
        accountManager.trans(transaction, amountTrans);
        printStateAccount(transaction, amountTrans, accountManager);
    }

    private static BigDecimal initAmountTrans(String amount) {
        return new BigDecimal(amount).setScale(2, ROUND_HALF_UP);
    }

    private static void printStateAccount(TransactionEnum transaction, BigDecimal amount, AccountManager accountManager){

        System.out.println("\n____Transaction " + transaction + ". Amount " + amount + ". State of accounts.");

        System.out.println("Refill account " + accountManager.getAccountRefill().getNumber()
                + ". Balance " + accountManager.getAccountRefill().getBalance());

        System.out.println("Transfer account " + accountManager.getAccountTransfer().getNumber()
                + ". Balance " + accountManager.getAccountTransfer().getBalance());
    }
}
