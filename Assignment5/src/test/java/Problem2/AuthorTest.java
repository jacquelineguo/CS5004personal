package Problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AuthorTest {
  Author author;
  Author author1;

  @Before
  public void setUp() throws Exception {
    author = new Author("Jessica", "Yu");
    author1 = new Author("Jessica", "Yu");
  }

  @Test
  public void isCreatorEqual() {
    assertTrue(author.isCreatorEqual(author1));
    author1 = new Author("Jessica", "Y");
    assertFalse(author.isCreatorEqual(author1));

    RecordingArtist artist = new RecordingArtist("Jessica", "Yu");
    assertFalse(author.isCreatorEqual(artist));
  }

  @Test
  public void testToString() {
    String result = "Author{firstName='Jessica', lastName='Yu'}";
    assertEquals(result, author.toString());
    author1 = new Author("Jessica", "Y");
    assertNotEquals(result, author1.toString());
  }

  @Test
  public void testHashCode() {
    assertEquals(author.hashCode(), author1.hashCode());

    author1 = new Author("Jessica", "Y");
    assertNotEquals(author, author1);
  }

  @Test
  public void testEquals() {
    assertEquals(author, author);
    assertEquals(author, author1);
    assertNotEquals(null, author);
    assertNotEquals(author, null);

    author1 = new Author("Jessica", "Y");
    assertNotEquals(author, author1);

    RecordingArtist artist = new RecordingArtist("Jessica", "Yu");
    assertNotEquals(artist, author);
  }
}