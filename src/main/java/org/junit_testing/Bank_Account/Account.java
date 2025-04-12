package org.junit_testing.Bank_Account;

import java.util.function.Supplier;

public class Account {

    private Integer accountNumber;
    private String CardHolderName;
    private Double balance;


    public Account() {
    }

    public Account(Integer accountNumber, String cardHolderName, Double balance) {
        this.accountNumber = accountNumber;
        this.CardHolderName = cardHolderName;
        this.balance = balance;
    }


    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCardHolderName() {
        return CardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        CardHolderName = cardHolderName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", CardHolderName='" + CardHolderName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
