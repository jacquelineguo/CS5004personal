package Problem2;

/**
 * Author class represents an individual person who is an author.
 */
public class Author extends AbstractIndividual{

  /**
   * Constructor or Author class.
   * @param firstName - the author's first name.
   * @param lastName - the author's last name.
   */
  public Author(String firstName, String lastName) {
    super(firstName, lastName);
  }

  @Override
  public String toString() {
    return "Author{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
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
