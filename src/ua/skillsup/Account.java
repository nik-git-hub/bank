package ua.skillsup;

import java.math.BigDecimal;

public class Account {

    private long number;
    private BigDecimal balance;

    public Account(long number, BigDecimal balance){
        this.number = number;
        this.balance = balance;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
