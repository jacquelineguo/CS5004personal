package problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VehicleTest {
    private Vehicle vehicleM;
    private Owner msZ;

    @Before
    public void setUp() throws Exception {
        msZ = new Owner("Jessica", "Z", "6140000000");
        vehicleM = new Vehicle(11, "abcd", msZ);
    }

    @Test
    public void getVIN() {
        assertEquals(11, vehicleM.getVIN());
    }

    @Test
    public void getLicensePlate() {
        assertEquals("abcd", vehicleM.getLicensePlate());
    }

    @Test
    public void setVIN() {
        vehicleM.setVIN(66);
        assertEquals(66, vehicleM.getVIN());
    }

    @Test
    public void setLicensePlate() {
        vehicleM.setLicensePlate("benz");
        assertEquals("benz", vehicleM.getLicensePlate());
    }

    @Test
    public void getFirstName() {
        assertEquals("Jessica", vehicleM.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("Z", vehicleM.getLastName());
    }

    @Test
    public void getPhoneNumber() {
        assertEquals("6140000000", vehicleM.getPhoneNumber());
    }

    @Test
    public void setFirstName() {
        msZ.setFirstName("Angela");
        assertEquals("Angela", vehicleM.getFirstName());
    }

    @Test
    public void setLastName() {
        vehicleM.setLastName("W");
        assertEquals("W", vehicleM.getLastName());
    }

    @Test
    public void setPhoneNumber() {
        vehicleM.setPhoneNumber("3108880000");
        assertEquals("3108880000", vehicleM.getPhoneNumber());
    }
}