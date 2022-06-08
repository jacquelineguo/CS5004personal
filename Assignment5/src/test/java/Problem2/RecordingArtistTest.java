package Problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RecordingArtistTest {
  RecordingArtist artist;
  RecordingArtist artist1;

  @Before
  public void setUp() throws Exception {
    artist = new RecordingArtist("Jessica", "Yu");
    artist1 = new RecordingArtist("Jessica", "Yu");
  }

  @Test
  public void testToString() {
    String result = "RecordingArtist{firstName='Jessica', lastName='Yu'}";
    assertEquals(result, artist.toString());
    artist1 = new RecordingArtist("Jessica", "Y");
    assertNotEquals(result, artist1.toString());
  }

  @Test
  public void testHashCode() {
    assertEquals(artist.hashCode(), artist1.hashCode());

    artist1 = new RecordingArtist("Jessica", "Y");
    assertNotEquals(artist, artist1);
  }

  @Test
  public void testEquals() {
    assertEquals(artist, artist);
    assertEquals(artist, artist1);
    assertNotEquals(null, artist);
    assertNotEquals(artist, null);

    artist1 = new RecordingArtist("Jessica", "Y");
    assertNotEquals(artist, artist1);

    Author author = new Author("Jessica", "Yu");
    assertNotEquals(author, artist);
  }
}