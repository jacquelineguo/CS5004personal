package problem3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AmountTest {
    private Amount amount;

    @Before
    public void setUp() throws Exception {
        amount = new Amount(100, 50);

        Amount n = new Amount(-1, -6);
        assertEquals(n, new Amount(0, 0));

        Amount m = new Amount(1, 120);
        assertEquals(m, new Amount(2, 20));
    }

    @Test
    public void add() {
        Amount n = new Amount(156, 5);
        Amount deposites = new Amount(55, 55);
        assertEquals(n, amount.add(deposites));
    }

    @Test
    public void subtract() {
        Amount s = new Amount(5, 5);
        Amount n = new Amount(95, 45);
        assertEquals(n, amount.subtract(s));

        Amount s1 = new Amount(-5, -5);
        assertEquals(amount, amount.subtract(s1));
    }

    @Test
    public void getCents() {
        assertEquals(50, amount.getCents());
    }

    @Test
    public void getDollars() {
        assertEquals(100, amount.getDollars());
    }
}