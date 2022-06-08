package Problem1;

import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class PhotographerTest {
  Photographer photographer;
  String[] genres = {"A", "B"};
  String[] awards = {"C", "D"};
  String[] exhibits = {"A"};

  @Before
  public void setUp() throws Exception {
    photographer = new Photographer("William", 50, genres, awards, exhibits);
  }

  @Test
  public void testEquals() throws Exception {
    assertEquals(photographer, photographer);
    assertNotEquals(null, photographer);
    assertNotEquals("William", photographer);

    Photographer photographer1 =
        new Photographer("William", 50, genres, awards, exhibits);
    assertEquals(photographer, photographer1);

    Photographer photographer2 =
        new Photographer("Jackson", 55, genres, awards, exhibits);
    assertNotEquals(photographer, photographer2);
  }

  @Test
  public void testHashCode() throws Exception{
    Photographer photographer1 =
        new Photographer("William", 50, genres, awards, exhibits);
    Photographer photographer2 =
        new Photographer("Jackson", 55, genres, awards, exhibits);

    assertEquals(photographer.hashCode(), photographer1.hashCode());
    assertNotEquals(photographer.hashCode(), photographer2.hashCode());
  }

  @Test
  public void testToString() throws Exception {
    String result = "Photographer: AbstractVisualArtist{AbstractArtist{" +
        "name='William'" +
        ", age=50" +
        ", genres=" + Arrays.toString(genres) +
        ", awards=" + Arrays.toString(awards) +
        "}, exhibits=" + Arrays.toString(exhibits) +
        '}';
    assertEquals(result, photographer.toString());

    Photographer photographer2 =
        new Photographer("Jackson", 55, genres, awards, exhibits);
    assertNotEquals(result, photographer2.toString());
  }
}