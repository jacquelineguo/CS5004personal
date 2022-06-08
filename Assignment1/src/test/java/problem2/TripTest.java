package problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TripTest {
    private Trip losToSea;
    private Time start;
    private Time end;

    @Before
    public void setUp() throws Exception {
        start = new Time(0, 0, 0);
        end = new Time(18, 30, 45);
        losToSea = new Trip("Los Angeles", "Seattle", start, end);
    }

    @Test
    public void getDuration() {
        Time duration = losToSea.getDuration();
        assertEquals(end, duration);

        losToSea.setStartTime(new Time(6, 30, 0));
        assertEquals(new Time(6, 30, 0), losToSea.getStartTime());
        duration = losToSea.getDuration();
        assertEquals(new Time(12, 0, 45), duration);

        losToSea.setStartTime(new Time(6, 30, 47));
        assertEquals(new Time(6, 30, 47), losToSea.getStartTime());
        duration = losToSea.getDuration();
        assertEquals(new Time(11, 59, 58), duration);

        losToSea.setStartTime(new Time(6, 45, 0));
        assertEquals(new Time(6, 45, 0), losToSea.getStartTime());
        duration = losToSea.getDuration();
        assertEquals(new Time(11, 45, 45), duration);
    }

    @Test
    public void getStartLocation() {
        assertEquals("Los Angeles", losToSea.getStartLocation());
    }

    @Test
    public void getEndLocation() {
        assertEquals("Seattle", losToSea.getEndLocation());
    }

    @Test
    public void setStartLocation() {
        losToSea.setStartLocation("Troy");
        assertEquals("Troy", losToSea.getStartLocation());
    }

    @Test
    public void setEndLocation() {
        losToSea.setEndLocation("Columbus");
        assertEquals("Columbus", losToSea.getEndLocation());
    }

    @Test
    public void getStartTime() {
        assertEquals(new Time (0, 0, 0), losToSea.getStartTime());
    }

    @Test
    public void getEndTime() {
        assertEquals(new Time(18, 30, 45), losToSea.getEndTime());
    }

    @Test
    public void setStartTime() {
        losToSea.setStartTime(new Time(6, 45, 0));
        assertEquals(new Time(6, 45, 0), losToSea.getStartTime());
    }

    @Test
    public void setEndTime() {
        losToSea.setEndTime(new Time(20, 45, 30));
        assertEquals(new Time(20, 45, 30), losToSea.getEndTime());
    }
}