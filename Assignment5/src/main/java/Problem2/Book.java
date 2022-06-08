package Problem2;

/**
 * Book class represent a book.
 */
public class Book extends AbstractItems{

  /**
   * Constructor of Book class.
   * @param author - the author of the book.
   * @param title - the title of the book.
   * @param releaseYear the publish year of the book.
   */
  public Book(Author author, String title, int releaseYear) {
    super(author, title, releaseYear);
  }

  /**
   * Check if the target creator equals this object's creator.
   * @param creator - the item creator.
   * @return true if equals, false otherwise.
   */
  @Override
  public boolean matchCreator(ICreators creator) {
    return this.creator.isCreatorEqual(creator);
  }

  @Override
  public String toString() {
    return "Book{" +
        "creator=" + creator +
        ", title='" + title + '\'' +
        ", releaseYear=" + releaseYear +
        '}';
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }
}
