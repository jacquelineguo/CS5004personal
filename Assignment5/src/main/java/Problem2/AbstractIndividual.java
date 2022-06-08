package Problem2;

import java.util.Objects;

/**
 * AbstractIndividual class represents the a person which can be an author or an artist.
 */
public abstract class AbstractIndividual implements ICreators{
  protected String firstName;
  protected String lastName;

  /**
   * Constructor of AbstractIndividual class.
   * @param firstName - person's first name.
   * @param lastName - person's last name.
   */
  public AbstractIndividual(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Check whether the target Creator equals this object's creator.
   * @param creator - a creator can be artist or author.
   * @return true if they're the same, false otherwise.
   */
  @Override
  public boolean isCreatorEqual(ICreators creator) {
    return this.equals(creator);
  }

  @Override
  public String toString() {
    return "AbstractIndividual{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
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
    AbstractIndividual that = (AbstractIndividual) o;
    return Objects.equals(firstName, that.firstName) && Objects
        .equals(lastName, that.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }
}
