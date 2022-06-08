package problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTest {
    private Time time;

    @Before
    public void setUp() throws Exception {
        time = new Time(6, 30, 45);

        Time t = new Time(25, 30, 45);
        assertEquals(1, t.getHour());

        Time t1 = new Time(2, 65, 45);
        assertEquals(5, t1.getMinutes());

        Time t2 = new Time(2, 2, 70);
        assertEquals(10, t2.getSeconds());

        Time t3 = new Time(-5, -6, -45);
        assertEquals(19, t3.getHour());
        assertEquals(54, t3.getMinutes());
        assertEquals(15, t3.getSeconds());
    }

    @Test
    public void getHour() {
        assertEquals(6, time.getHour());
    }

    @Test
    public void setHour() {
        time.setHour(18);
        assertEquals(18, time.getHour());

        time.setHour(26);
        assertEquals(2, time.getHour());

        time.setHour(-5);
        assertEquals(19, time.getHour());
    }

    @Test
    public void getMinutes() {
        assertEquals(30, time.getMinutes());
    }

    @Test
    public void setMinutes() {
        time.setMinutes(55);
        assertEquals(55, time.getMinutes());

        time.setMinutes(67);
        assertEquals(7, time.getMinutes());

        time.setMinutes(-54);
        assertEquals(6, time.getMinutes());
    }

    @Test
    public void getSeconds() {
        assertEquals(45, time.getSeconds());
    }

    @Test
    public void setSeconds() {
        time.setSeconds(34);
        assertEquals(34, time.getSeconds());

        time.setSeconds(70);
        assertEquals(10, time.getSeconds());

        time.setSeconds(-6);
        assertEquals(54, time.getSeconds());
    }

    @Test
    public void equals() {
        Time time1 = new Time(18, 18, 45);
        Time time2 = new Time(18, 18, 45);
        assertEquals(time1, time2);

        time2.setHour(23);
        assertNotEquals(time1, time2);
        time1.setHour(23);
        assertEquals(time1, time2);

        time2.setMinutes(59);
        assertNotEquals(time1, time2);
        time1.setMinutes(59);
        assertEquals(time1, time2);

        time2.setSeconds(6);
        assertNotEquals(time1, time2);
        time1.setSeconds(6);
        assertEquals(time1, time2);
    }
}