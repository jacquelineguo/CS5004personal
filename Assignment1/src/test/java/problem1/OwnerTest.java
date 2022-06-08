package problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OwnerTest {
    private Owner msZ;

    @Before
    public void setUp() throws Exception {
        msZ = new Owner("Jessica", "Z", "6140000000");
    }

    @Test
    public void getFirstName() {
        assertEquals("Jessica", msZ.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("Z", msZ.getLastName());
    }

    @Test
    public void getPhoneNumber() {
        assertEquals("6140000000", msZ.getPhoneNumber());
    }

    @Test
    public void setFirstName() {
        msZ.setFirstName("Angela");
        assertEquals("Angela", msZ.getFirstName());
    }

    @Test
    public void setLastName() {
        msZ.setLastName("W");
        assertEquals("W", msZ.getLastName());
    }

    @Test
    public void setPhoneNumber() {
        msZ.setPhoneNumber("3108880000");
        assertEquals("3108880000", msZ.getPhoneNumber());

        msZ.setPhoneNumber("310");
        assertEquals("0000000000", msZ.getPhoneNumber());
    }
}