package org.junit_testing.Bank_Account;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {
    private static AccountService account;

    @BeforeEach
    void setUp() {
        account = new AccountService();
        System.out.println(" SetUp is executed before each test method... ");
    }

    @AfterEach
    void tearDown() {
        account = null;
        System.out.println("AfterEach is executed after each test case... ");
    }

    @BeforeAll
    static void setUpBeforeClass() {
        account = new AccountService();
        System.out.println("BeforeAll is executed ONCE beforeAll test cases... ");
    }

    @AfterAll
    static void tearDownAfterClass() {
        account = null;
        System.out.println("AfterAll is executed ONCE after all test methods...");
    }

    @Test
    void createAccount() {
        Account actualAccount = account.createAccount(653748901, "Anisa Cela", 20.00);
        assertNotNull(actualAccount);
        assertEquals(653748901, actualAccount.getAccountNumber());
        assertEquals("Anisa Cela", actualAccount.getCardHolderName());
        assertEquals(20.00, actualAccount.getBalance());
    }


    @Test
    void removeAccount() {
        Account account2 = account.createAccount(657654765, "Anisa Xhacka", 680.00);
        Integer actualAccountNumber = account2.getAccountNumber();
        assertNotNull(actualAccountNumber);
        //  assertNotEquals(NULL, account2.getAccountNumber());
        assertEquals("Anisa Xhacka", account2.getCardHolderName());
        assertEquals(680.00, account2.getBalance());

        AccountNotFoundException assertExceptionError = assertThrows(AccountNotFoundException.class, () -> {
            account.removeAccount(657654765);
        });

        assertEquals("AccountNumber not found!", assertExceptionError.getMessage());
    }

    @Test
    void getAccountsRecord() {
        Account account1 = account.createAccount(25465786, "Anisa Cela", 2345.00);
        assertNotNull(account1);
        assertEquals(25465786, account1.getAccountNumber());
        assertEquals("Anisa Cela", account1.getCardHolderName());
        assertEquals(2345.00, account1.getBalance());

        AccountNotFoundException assertThrowsException = assertThrows(AccountNotFoundException.class, () -> {
            account.getAccountsRecord(25465786, "Anisa Cela", 2345.00);
        });
        assertEquals("AccountNumber is not found!!", assertThrowsException.getMessage());
    }

    @Test
    void deposit() {
        Account accountDeposit = account.getAccountsRecord(653748901, "Anisa Cela", 20.00);
        Integer accountDesired = accountDeposit.getAccountNumber();
        Double amountDesired = accountDeposit.getBalance();
        assertNotNull(accountDesired, () -> "It is my account number where I need to withdraw some money...");
        assertNotNull(amountDesired);
        // Depozituam vleren prej 260
        Account depositedAmount = account.deposit(280.00, 653748901);
        assertEquals(653748901, depositedAmount.getAccountNumber());
        assertEquals("Anisa Cela", depositedAmount.getCardHolderName(), "Anisa Cela deposited 260.00$ into her account!");
        assertEquals(280, depositedAmount.getBalance());
        AccountNotFoundException assertException = assertThrows(AccountNotFoundException.class, () -> {
            account.deposit(280.00, 653748901);
        });

        assertEquals("Account is not found .", assertException.getMessage());
    }

    @Test
    void withdrawAmount() {
        Account accountU = account.getAccountsRecord(25465786, "Anisa Cela", 2345.00);
        Integer accountId = accountU.getAccountNumber();
        Double balanceAmount = accountU.getBalance();
        assertNotNull(accountId);
        assertNotNull(balanceAmount);
        Account accountW = account.withdrawAmount(2345.00, 25465786, 500.00);
        assertEquals(1885.00, accountW.getBalance());
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdrawAmount(2345.00, 25465786, 5000.00);
        });
        assertEquals("Insuficient Balance", exception.getMessage());

    }

    @Test
    void moneyTransfer() {
        Account fromAccount = account.createAccount(1234567890, "Anisas Cela", 900.00);
        Account toAccount = account.createAccount(1234567891, "Aria Bushati", 350.00);
       // Double transferFunds = fromAccount.getBalance() - toAccount.getBalance();
        Double moneyTransfer = 300.00;
        assertNotNull(fromAccount.getAccountNumber());
        assertNotNull(toAccount.getAccountNumber());
        assertNotNull(fromAccount.getBalance());
        assertNotNull(toAccount.getBalance());
        assertEquals(900.00, fromAccount.getBalance());
        assertEquals(350.00, toAccount.getBalance());

        account.moneyTransfer(1234567890, 1234567891, 900.00, 350.00, 300.00);
        assertEquals(600.00, fromAccount.getBalance());
        assertEquals(650.00, toAccount.getBalance());

        IllegalArgumentException illegalException = assertThrows(IllegalArgumentException.class, () -> {
            account.moneyTransfer(1234567891, 1234567890, 650.00, 900.00, 700.00);
        });
        assertEquals("Insuficient Funds", illegalException.getMessage());

    }

}