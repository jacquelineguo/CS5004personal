package Problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BookTest {
  Book book;
  Book book1;
  Author author;
  Author author1;

  @Before
  public void setUp() throws Exception {
    author = new Author("Jessica", "Yu");
    author1 = new Author("Steven", "Yu");
    book = new Book(author, "A", 2020);
    book1 = new Book(author1, "A", 2020);
  }

  @Test
  public void matchCreator() {
    assertTrue(book.matchCreator(author));
    assertFalse(book.matchCreator(author1));
  }

  @Test
  public void testToString() {
    String result = "Book{creator=Author{firstName='Jessica', lastName='Yu'}, "
        + "title='A', releaseYear=2020}";
    assertEquals(result, book.toString());

    assertNotEquals(result, book1);
  }

  @Test
  public void testHashCode() {
    Book book2 = new Book(author, "A", 2020);
    assertEquals(book.hashCode(), book2.hashCode());

    assertNotEquals(book2.hashCode(), book1.hashCode());
  }

  @Test
  public void testEquals() {
    Book book2 = new Book(author, "A", 2020);
    assertEquals(book, book);
    assertEquals(book, book2);
    assertNotEquals(book, book1);
    assertNotEquals(null, book);
    assertNotEquals(book1, null);
  }
}