package Problem1;

import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class FilmmakerTest {
  Filmmaker filmmaker;
  String[] genres = {"A", "B"};
  String[] awards = {"C", "D"};
  String[] movies = {"A"};
  String[] series = {"D"};
  String[] multimedia = {"F"};
  String[] movies1 = {"O", "P"};

  @Before
  public void setUp() throws Exception {
    filmmaker = new
        Filmmaker("Steven", 74, genres, awards, movies, series, multimedia);
  }

  @Test
  public void testEquals() throws Exception{
    assertEquals(filmmaker, filmmaker);
    assertNotEquals(null, filmmaker);
    assertNotEquals("steven", filmmaker);

    Filmmaker filmmaker1 = new
        Filmmaker("Steven", 74, genres, awards, movies, series, multimedia);
    assertEquals(filmmaker, filmmaker1);

    Filmmaker filmmaker2 = new
        Filmmaker("Jennifer Lawrence", 35, genres, awards, movies1, series, multimedia);
    assertNotEquals(filmmaker, filmmaker2);
  }

  @Test
  public void testHashCode() throws Exception{
    Filmmaker filmmaker1 = new
        Filmmaker("Steven", 74, genres, awards, movies, series, multimedia);
    Filmmaker filmmaker2 = new
        Filmmaker("Jennifer Lawrence", 35, genres, awards, movies1, series, multimedia);

    assertEquals(filmmaker.hashCode(), filmmaker1.hashCode());
    assertNotEquals(filmmaker.hashCode(), filmmaker2.hashCode());
  }

  @Test
  public void testToString() throws Exception{
    String result = "Filmmaker: AbstractFilmArtist{AbstractArtist{" +
        "name='Steven'" +
        ", age=74" +
        ", genres=" + Arrays.toString(genres) +
        ", awards=" + Arrays.toString(awards) +
        "}, movies=" + Arrays.toString(movies) +
        ", series=" + Arrays.toString(series) +
        ", multimedia=" + Arrays.toString(multimedia) +
        '}';
    assertEquals(result, filmmaker.toString());

    Filmmaker filmmaker2 = new
        Filmmaker("Jennifer Lawrence", 35, genres, awards, movies1, series, multimedia);
    assertNotEquals(result, filmmaker2);
  }
}