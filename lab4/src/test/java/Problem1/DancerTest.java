package Problem1;

import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class DancerTest {
  Dancer dancer;
  String[] genres = {"A", "B"};
  String[] awards = {"C", "D"};
  String[] movies = {"A"};
  String[] series = {"D"};
  String[] multimedia = {"F"};

  @Before
  public void setUp() throws Exception {
    dancer = new
        Dancer("Misty", 30, genres, awards, movies, series, multimedia);
  }

  @Test
  public void testEquals() throws Exception{
    assertEquals(dancer, dancer);
    assertNotEquals(null, dancer);
    assertNotEquals("dancer", dancer);

    Dancer dancer1 = new Dancer("Misty", 30, genres, awards, movies, series, multimedia);
    assertEquals(dancer1, dancer);

    Dancer dancer2 = new Dancer
        ("Jennifer Lawrence", 35, genres, awards, genres, series, multimedia);
    assertNotEquals(dancer1, dancer2);
  }

  @Test
  public void testHashCode() throws Exception{
    Dancer dancer1 = new Dancer("Misty", 30, genres, awards, movies, series, multimedia);
    Dancer dancer2 = new Dancer
        ("Jennifer Lawrence", 35, genres, awards, movies, series, multimedia);
    assertEquals(dancer.hashCode(), dancer1.hashCode());
    assertNotEquals(dancer.hashCode(), dancer2.hashCode());
  }

  @Test
  public void testToString() throws Exception{
    String result = "Dancer: AbstractFilmArtist{AbstractArtist{" +
        "name='Misty'" +
        ", age=30" +
        ", genres=" + Arrays.toString(genres) +
        ", awards=" + Arrays.toString(awards) +
        "}, movies=" + Arrays.toString(movies) +
        ", series=" + Arrays.toString(series) +
        ", multimedia=" + Arrays.toString(multimedia) +
        '}';
    assertEquals(result, dancer.toString());

    Dancer dancer2 = new Dancer
        ("Jennifer Lawrence", 35, genres, awards, movies, series, multimedia);
    assertNotEquals(result, dancer2);
  }

  @Test
  public void testEquals1() throws Exception {
    Poet poet = new
        Poet("Emily", 66, genres, awards, "ABC", "S");
    assertFalse(dancer.equals(poet));
  }
}