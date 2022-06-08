package Problem2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class CatalogTest {
  Catalog catalog;
  Catalog catalog1;
  Book book;
  Book book1;
  Author author;
  Author author1;
  ArrayList<AbstractItems> items;
  ArrayList<AbstractItems> items1;
  Music music;
  Music music1;
  Band band;
  ArrayList<RecordingArtist> members;
  RecordingArtist artist;
  RecordingArtist artist1;


  @Before
  public void setUp() throws Exception {
    author = new Author("Jessica", "Yu");
    author1 = new Author("Steven", "Yu");
    artist = new RecordingArtist("Helen", "Yu");
    artist1 = new RecordingArtist("Aria", "Yu");
    book = new Book(author, "A", 2020);
    book1 = new Book(author1, "U", 2020);
    members = new ArrayList<RecordingArtist>();
    members.add(artist);
    members.add(artist1);
    band = new Band("W", members);
    music = new Music(band,"Da", 2013);
    music1 = new Music(artist1, "R", 2018);
    items = new ArrayList<AbstractItems>();
    items1 = new ArrayList<AbstractItems>();
    items.add(book);
    items.add(music);
    catalog = new Catalog(items);
    items1.add(music1);
    items1.add(book);
    catalog1 = new Catalog(items1);
  }

  @Test
  public void addItem() {
    catalog.addItem(music1);
    ArrayList<AbstractItems> items2 = new ArrayList<AbstractItems>();
    items2.add(book);
    items2.add(music);
    items2.add(music1);
    Catalog catalog2 = new Catalog(items2);
    assertEquals(catalog, catalog2);
  }

  @Test
  public void removeItem() throws Exception{
    ArrayList<AbstractItems> items2 = new ArrayList<AbstractItems>();
    items2.add(book);
    Catalog catalog2 = new Catalog(items2);
    catalog.removeItem(music);

    assertEquals(catalog2, catalog);
  }

  @Test (expected = EmptyCatalogException.class)
  public void invalidRemove() throws EmptyCatalogException{
    ArrayList<AbstractItems> items2 = new ArrayList<AbstractItems>();
    Catalog catalog2 = new Catalog(items2);
    catalog2.removeItem(music);
  }

  @Test
  public void search() {
    catalog.addItem(book1);
    ArrayList<AbstractItems> result = catalog.search("a");
    ArrayList<AbstractItems> expected = new ArrayList<>();
    expected.add(book);
    expected.add(music);
    assertEquals(result, expected);
  }

  @Test
  public void testSearch() {
    ArrayList<AbstractItems> result = catalog.search(author);
    ArrayList<AbstractItems> expected = new ArrayList<>();
    expected.add(book);
    assertEquals(result, expected);

    // author1 not found
    ArrayList<AbstractItems> result1 = catalog.search(author1);
    ArrayList<AbstractItems> expected1 = new ArrayList<>();
    assertEquals(result, expected);
  }

  @Test
  public void testSearch1() {
    ArrayList<AbstractItems> result = catalog.search(artist);
    ArrayList<AbstractItems> expected = new ArrayList<>();
    expected.add(music);
    assertEquals(result, expected);

    // artist1 not found
    ArrayList<AbstractItems> result1 = catalog.search(artist1);
    ArrayList<AbstractItems> expected1 = new ArrayList<>();
    assertEquals(result, expected);
  }

  @Test
  public void testToString() {
    String expected = "Catalog{list=[Book{creator=Author{firstName='Jessica', lastName='Yu'}, "
        + "title='A', releaseYear=2020}, Music{creator=Band{groupName='W', "
        + "members=[RecordingArtist{firstName='Helen', lastName='Yu'}, "
        + "RecordingArtist{firstName='Aria', lastName='Yu'}]}, title='Da', releaseYear=2013}]}";
    assertEquals(expected, catalog.toString());
    assertNotEquals(expected, catalog1.toString());
  }

  @Test
  public void testEquals() {
    Catalog catalog2 = new Catalog(items);
    assertEquals(catalog, catalog);
    assertEquals(catalog2, catalog);
    assertNotEquals(null, catalog);
    assertNotEquals(catalog1, null);
    assertNotEquals(catalog1, catalog);
    assertNotEquals("Catalog", catalog2);
  }

  @Test
  public void testHashCode() {
    Catalog catalog2 = new Catalog(items);
    assertEquals(catalog.hashCode(), catalog2.hashCode());

    assertNotEquals(catalog.hashCode(), catalog1.hashCode());
  }
}