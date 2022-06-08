package Problem2;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Catalog class represents a collection of all the items in the library and to implement search
 * functionality.
 */
public class Catalog {

  private ArrayList<AbstractItems> list;

  /**
   * Constructor of Catalog class.
   * @param list - list of library collection.
   */
  public Catalog(ArrayList<AbstractItems> list) {
    this.list = list;
  }

  /**
   * Add items to the collection list.
   * @param item - items to be added such as book, music.
   */
  public void addItem(AbstractItems item) {
    if (item != null) {
      this.list.add(item);
    }
  }

  /**
   * Remove items from the collection list.
   * @param item - items to be removed such as book, music.
   * @throws EmptyCatalogException if list is empty.
   */
  public void removeItem(AbstractItems item) throws EmptyCatalogException{
    if (this.isEmpty()) {
      throw new EmptyCatalogException();
    }
    list.remove(item);
  }

  /**
   * Helper function check if the list is empty.
   * @return true if empty, false otherwise.
   */
  private boolean isEmpty() {
    return this.list.isEmpty();
  }

  /**
   * Search items' title in the collection list that contains searching keyword.
   * @param keyword - keyword.
   * @return the list of items that contains keyword.
   */
  public ArrayList<AbstractItems> search(String keyword) {
    ArrayList<AbstractItems> result = new ArrayList<>();
    for (AbstractItems item : this.list) {
      if (item.title.toLowerCase().contains(keyword)) {
        result.add(item);
      }
    }
    return result;
  }

  /**
   * Search items in the collection list that contains searching author.
   * @param author - author.
   * @return the list of items that contains author.
   */
  public ArrayList<AbstractItems> search(Author author) {
    ArrayList<AbstractItems> result = new ArrayList<>();
    for (AbstractItems item : this.list) {
      if (item.matchCreator(author)) {
        result.add(item);
      }
    }
    return result;
  }

  /**
   * Search items in the collection list that contains searching artist.
   * @param artist - artist.
   * @return the list of items that contains artist.
   */
  public ArrayList<AbstractItems> search(RecordingArtist artist) {
    ArrayList<AbstractItems> result = new ArrayList<>();
    for (AbstractItems item : this.list) {
      if (item.matchCreator(artist)) {
        result.add(item);
      }
    }
    return result;
  }

  @Override
  public String toString() {
    return "Catalog{" +
        "list=" + list +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    Catalog catalog = (Catalog) o;
    return Objects.equals(list, catalog.list);
  }

  @Override
  public int hashCode() {
    return Objects.hash(list);
  }
}
