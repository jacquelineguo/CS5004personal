package Problem2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class MusicTest {
  Music music;
  Music music1;
  Band band;
  Band band1;
  ArrayList<RecordingArtist> members;
  ArrayList<RecordingArtist> members1;
  RecordingArtist artist;
  RecordingArtist artist1;
  RecordingArtist artist2;

  @Before
  public void setUp() throws Exception {
    artist = new RecordingArtist("Jessica", "Yu");
    artist1 = new RecordingArtist("Aria", "Yu");
    artist2 = new RecordingArtist("Hanna", "W");
    members = new ArrayList<>();
    members1 = new ArrayList<>();
    members.add(artist);
    members.add(artist1);
    members1.add(artist);
    members1.add(artist2);
    band = new Band("A", members);
    band1 = new Band("A", members1);
    music = new Music(artist, "A", 2020);
    music1 = new Music(band, "B", 2019);
  }

  @Test
  public void matchCreator() {
    assertTrue(music.matchCreator(artist));
    assertFalse(music.matchCreator(artist1 ));

    assertTrue(music1.matchCreator(artist1));
    assertFalse(music1.matchCreator(artist2));
  }

  @Test
  public void testToString() {
    String result = "Music{creator=RecordingArtist{firstName='Jessica', "
        + "lastName='Yu'}, title='A', releaseYear=2020}";
    assertEquals(result, music.toString());

    assertNotEquals(result, music1);
  }

  @Test
  public void testEquals() {
    assertEquals(music, music);
    assertEquals(music1, music1);
    assertNotEquals(null, music);
    assertNotEquals(music1, null);
    assertNotEquals(music, music1);
    assertNotEquals("music", music);
  }

  @Test
  public void testHashCode() {
    Music music2 = new Music(artist, "A", 2020);
    assertEquals(music.hashCode(),music2.hashCode());

    assertNotEquals(music.hashCode(), music1.hashCode());
  }
}