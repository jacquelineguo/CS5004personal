package Problem2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class BandTest {
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
  }

  @Test
  public void isCreatorEqual() {
    assertTrue(band.isCreatorEqual(artist));
    assertFalse(band.isCreatorEqual(artist2));
  }

  @Test
  public void testToString() {
    String result = "Band{groupName='A', members=[RecordingArtist{firstName='Jessica', "
        + "lastName='Yu'}, RecordingArtist{firstName='Aria', lastName='Yu'}]}";
    assertEquals(result, band.toString());

    assertNotEquals(result, band1.toString());
  }

  @Test
  public void testEquals() {
    assertEquals(band, band);
    Band band2 = new Band("A", members);
    assertEquals(band, band2);
    assertNotEquals(null, band);
    assertNotEquals(band, null);

    assertNotEquals(band, band1);
  }

  @Test
  public void testHashCode() {
    Band band2 = new Band("A", members);
    assertEquals(band.hashCode(), band2.hashCode());

    assertNotEquals(band, band1);
  }
}