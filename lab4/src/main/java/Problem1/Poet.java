package Problem1;

import java.util.Objects;

/**
 * A Poet class represents a poet.
 */
public class Poet extends AbstractArtist{
  private String publishingCompany;
  private String lastCollection;

  /**
   * Constructor of the Poet class.
   * @param name - an artist's name.
   * @param age - the artist's age.
   * @param genres - an Artist’sg genres.
   * @param awards - all awards that an Artist received.
   * @param publishingCompany - a Poet’s publishing company.
   * @param lastCollection - representing the title of the latest published collection of poems.
   * @throws InvalidAgeException if the age is not in range 0 to 128.
   */
  public Poet(String name, Integer age, String[] genres, String[] awards,
      String publishingCompany, String lastCollection) throws InvalidAgeException {
    super(name, age, genres, awards);

    this.publishingCompany = publishingCompany;
    this.lastCollection = lastCollection;
  }


  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.publishingCompany, this.lastCollection);
  }

  @Override
  public String toString() {
    return "Poet: " + super.toString() +
        ", publishingCompany='" + this.publishingCompany + '\'' +
        ", lastCollection='" + this.lastCollection + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Poet)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Poet poet = (Poet) o;
    return Objects.equals(publishingCompany, poet.publishingCompany) && Objects
        .equals(lastCollection, poet.lastCollection);
  }

  public String getPublishingCompany() {
    return this.publishingCompany;
  }

  public String getLastCollection() {
    return this.lastCollection;
  }
}
