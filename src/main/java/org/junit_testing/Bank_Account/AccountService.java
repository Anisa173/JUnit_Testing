package org.junit_testing.Bank_Account;

import java.util.HashMap;
import java.util.Map;

public class AccountService {
    private Map<Integer, Account> accountsMap = new HashMap<>();

    public Account createAccount(Integer accountNumber, String CardHolderName, Double balance) {
        if (accountsMap.containsKey(accountNumber)) {
            throw new IllegalArgumentException("AccountNumber is an unique identified account number!!!!");
        }
        Account account = new Account(accountNumber, CardHolderName, balance);
        accountsMap.put(accountNumber, account);
        return account;
    }

    public void removeAccount(Integer accountNumber) {
        Account account = accountsMap.get(accountNumber);
        if (account == null) {
            throw new AccountNotFoundException("The CardBank of the specified Cardholder is expired!");
        } else {
            accountsMap.remove(account);
        }
    }

    public Account getAccountsRecord(Integer accountNumber, String CardHolderName, Double balance) {
        Account account = accountsMap.get(accountNumber);

        if (account == null) {
            throw new AccountNotFoundException("There is no Card_Account in the HashMap. ");
        }
        return account;

    }

    public Account deposit(Double balance, Integer accountNumber) {
        Account account1 = accountsMap.get(accountNumber);
        Account account2 = accountsMap.get(balance);
        double depositedValue = 0;

        if (account1 == null) {
            throw new AccountNotFoundException("There is no account");
        } else {
            if (account2 == null) {
                throw new NullPointerException("The balance of an account can not be null!");
            } else {
                double newBalance = account2.getBalance() + depositedValue;
                account2.setBalance(newBalance);
            }
        }
        return account2;
    }


    public Account withdrawAmount(Double balance, Integer accountNumber, Double valueAmount) {
        Account acc = accountsMap.get(accountNumber);
        Account account = accountsMap.get(balance);
        if (acc == null) {
            throw new AccountNotFoundException("You don't possess a Bank_Card!!!");
        } else {
            if (account == null) {
                throw new NullPointerException("Account Balance shouldn't be NULL!");
            } else {
                if (valueAmount > account.getBalance()) {
                    throw new IllegalArgumentException("The desiredValue can not be withdrawn because you don't accomplish conditions!!");
                } else {
                    //  double withdrawAmount = valueAmount;
                    double newBalance = account.getBalance() - valueAmount;
                    account.setBalance(newBalance);
                }
            }
        }
        return account;
    }

    public void moneyTransfer(Integer fromAccountNumber, Integer toAccountNumber, Double balance1,
                              Double balance2, Double moneyTransfer) {
        Account acc1 = accountsMap.get(fromAccountNumber);
        Account acc2 = accountsMap.get(toAccountNumber);
        Account acc11 = accountsMap.get(balance1);
        Account acc22 = accountsMap.get(balance2);
        if ((acc1 == null) && (acc2 == null)) {
            throw new AccountNotFoundException(" There are not any user's account!!! ");
        } else {
            if ((acc11 == null) && (acc22 == null)) {
                throw new NullPointerException("Account balance shouldn't be NULL!!");
            } else {
                if (moneyTransfer > acc1.getBalance()) {
                    throw new IllegalArgumentException("Insuficient Funds!!!");
                } else {
                    double fromAccountBalance = acc1.getBalance() - moneyTransfer;
                    double toAccountBalance = acc22.getBalance() + moneyTransfer;
                    acc1.setBalance(fromAccountBalance);
                    acc2.setBalance(toAccountBalance);
                }
                if (moneyTransfer > acc2.getBalance()) {
                    throw new IllegalArgumentException("Insuficient Funds!!!");
                } else {
                    double fromAccountBalance = acc2.getBalance() - moneyTransfer;
                    double toAccountBalance = acc1.getBalance() + moneyTransfer;
                    acc1.setBalance(toAccountBalance);
                    acc2.setBalance(fromAccountBalance);
                }
            }
        }
    }


}



