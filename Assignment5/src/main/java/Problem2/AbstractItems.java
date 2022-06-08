package Problem2;


import java.util.Objects;

/**
 * AbstractItems represents a collection contains the item’s creator, item’s title, and
 * year the item was released or published.
 */
public abstract class AbstractItems {
  protected ICreators creator;
  protected String title;
  protected int releaseYear;

  /**
   * Constructor of AbstractItems class.
   * @param creator - a creator can be artist or author.
   * @param title - the item’s title.
   * @param releaseYear - the year the item was released or published.
   */
  public AbstractItems(ICreators creator, String title, int releaseYear) {
    this.creator = creator;
    this.title = title;
    this.releaseYear = releaseYear;
  }

  /**
   * The abstract method that determine whether this item has the target creator.
   * @param creator - the item creator.
   * @return true if it has, false otherwise.
   */
  public abstract boolean matchCreator(ICreators creator);

  @Override
  public String toString() {
    return "AbstractItems{" +
        "creator=" + creator +
        ", title='" + title + '\'' +
        ", releaseYear=" + releaseYear +
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
    AbstractItems that = (AbstractItems) o;
    return releaseYear == that.releaseYear && Objects.equals(creator, that.creator)
        && Objects.equals(title, that.title);
  }

  @Override
  public int hashCode() {
    return Objects.hash(creator, title, releaseYear);
  }
}
