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

        System.out.printf("\n" +
                "Transaction <%-8s> ; amount %-7s\n", transaction, amount.toString());
        System.out.println("State of accounts");
        System.out.printf("%-8s account %-13d ; Balance %-7s", "REFILL",
                accountManager.getAccountRefill().getNumber(),
                accountManager.getAccountRefill().getBalance().toString());

        System.out.printf("\n%-8s account %-13d ; Balance %-7s \n", "TRANSFER",
                accountManager.getAccountTransfer().getNumber(),
                accountManager.getAccountTransfer().getBalance().toString());
    }
}
