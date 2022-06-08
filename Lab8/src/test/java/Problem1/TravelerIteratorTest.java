package Problem1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class TravelerIteratorTest {
  Destination destination;
  Destination destination1;
  Destination destination2;
  Destination destination3;
  Traveler traveler;
  Traveler traveler1;
  TravelerIterator iterator;

  @Before
  public void setUp() throws Exception {
    destination = new Destination("LA", "US",
        "LAX", 1000F);
    destination1 = new Destination("HongKong", "CHN",
        "XXX", 5000F);
    destination2 = new Destination("Paris", "FR", "AAA",
        3000F);
    destination3 = new Destination("Detroit", "US",
        "DTW", 2000F);
    List<Destination> first = new ArrayList<>();
    first.add(destination);
    first.add(destination1);
    first.add(destination2);
    traveler = new Traveler("A", "B", first);
    List<Destination> second = new ArrayList<>();
    second.add(destination);
    second.add(destination3);
    traveler1 = new Traveler("C", "D", second);

    List<Traveler> travelers = new ArrayList<>();
    travelers.add(traveler);
    travelers.add(traveler1);
    iterator = new TravelerIterator(travelers);
  }

  @Test
  public void hasNext() {
    assertTrue(iterator.hasNext());
  }

  @Test
  public void next() {
    assertTrue(traveler1.equals(iterator.next()));
  }
}