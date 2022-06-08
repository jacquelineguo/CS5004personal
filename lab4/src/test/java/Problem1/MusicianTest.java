package Problem1;

import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MusicianTest {
  Musician musician;
  String[] genres = {"A", "B"};
  String[] awards = {"C", "D"};

  @Before
  public void setUp() throws Exception {
    musician = new
        Musician("Taylor", 31, genres, awards, "ABC", "1989");
  }

  @Test
  public void testEquals() throws Exception{
    assertEquals(musician, musician);
    assertNotEquals(null, musician);
    assertNotEquals("Taylor", musician);

    Musician musician1 = new
        Musician("Taylor", 31, genres, awards, "ABC", "1989");
    assertEquals(musician, musician1);

    Musician musician2 = new
        Musician("Misty", 30, genres, awards, "A", "b");
    assertNotEquals(musician, musician2);
  }

  @Test
  public void testHashCode() throws Exception{
    Musician musician1 = new
        Musician("Taylor", 31, genres, awards, "ABC", "1989");
    Musician musician2 = new
        Musician("Misty", 30, genres, awards, "A", "b");

    assertEquals(musician.hashCode(), musician1.hashCode());
    assertNotEquals(musician.hashCode(), musician2.hashCode());
  }

  @Test
  public void testToString() throws Exception{
    String result = "Musician: AbstractArtist{" +
        "name='Taylor'" +
        ", age=31" +
        ", genres=" + Arrays.toString(genres) +
        ", awards=" + Arrays.toString(awards) +
        "}, recordingCompany='ABC', lastAlbum='1989'" +
        '}';
    assertEquals(result, musician.toString());

    Musician musician2 = new
        Musician("Misty", 30, genres, awards, "A", "b");
    assertNotEquals(result, musician2.toString());
  }

  @Test
  public void getRecordingCompany() {
    assertEquals("ABC", musician.getRecordingCompany());
  }

  @Test
  public void getLastAlbum() {
    assertEquals("1989", musician.getLastAlbum());
  }
}