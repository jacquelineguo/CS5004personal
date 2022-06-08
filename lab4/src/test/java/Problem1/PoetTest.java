package Problem1;

import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class PoetTest {
  Poet poet;
  String[] genres = {"A", "B"};
  String[] awards = {"C", "D"};

  @Before
  public void setUp() throws Exception {
    poet = new Poet("Emily", 66, genres, awards, "ABC", "S");
  }

  @Test
  public void testHashCode() throws Exception {
    Poet poet1 = new
        Poet("Emily", 66, genres, awards, "ABC", "S");
    Poet poet2 = new
        Poet("Emily", 66, genres, awards, "GWE", "wkj");

    assertEquals(poet.hashCode(), poet1.hashCode());
    assertNotEquals(poet1.hashCode(), poet2.hashCode());
  }

  @Test
  public void testToString() throws Exception {
    String result = "Poet: AbstractArtist{" +
        "name='Emily'" +
        ", age=66" +
        ", genres=" + Arrays.toString(genres) +
        ", awards=" + Arrays.toString(awards) +
        "}, publishingCompany='ABC', lastCollection='S'" +
        '}';
    assertEquals(result, poet.toString());

    Poet poet2 = new
        Poet("Emily", 66, genres, awards, "GWE", "wkj");
    assertNotEquals(result, poet2);
  }

  @Test
  public void testEquals() throws Exception {
    assertEquals(poet, poet);
    assertNotEquals(null, poet);
    assertNotEquals("Emily", poet);

    Poet poet1 = new
        Poet("Emily", 66, genres, awards, "ABC", "S");
    Poet poet2 = new
        Poet("Emily", 66, genres, awards, "GWE", "wkj");
    assertEquals(poet1, poet);
    assertNotEquals(poet, poet2);
  }

  @Test
  public void getPublishingCompany() {
    assertEquals("ABC", poet.getPublishingCompany());
  }

  @Test
  public void getLastCollection() {
    assertEquals("S", poet.getLastCollection());
  }
}