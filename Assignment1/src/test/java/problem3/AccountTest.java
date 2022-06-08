package problem3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {
    private Account account;
    private Amount balance;

    @Before
    public void setUp() throws Exception {
        balance = new Amount(100, 50);
        account = new Account("Jessica", "Z", balance);
    }

    @Test
    public void deposit() {
        Amount newAmount = new Amount(400, 50);
        Amount depositeAmount = new Amount(300, 0);
        assertEquals(newAmount, account.deposit(depositeAmount).getBalance());

        Amount depositeAmount1 = new Amount(-300, -10);
        assertEquals(balance, account.deposit(depositeAmount1).getBalance());
    }

    @Test
    public void withdraw() {
        Amount newAmount = new Amount(93, 35);
        Amount withdrawAmount = new Amount(7, 15);
        assertEquals(newAmount, account.withdraw(withdrawAmount).getBalance());

        Amount withdrawAmount1 = new Amount(-7, -15);
        assertEquals(balance, account.withdraw(withdrawAmount1).getBalance());
    }

    @Test
    public void getBalance() {
        assertEquals(balance, account.getBalance());
    }

    @Test
    public void getFirstName() {
        assertEquals("Jessica", account.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("Z", account.getLastName());
    }
}