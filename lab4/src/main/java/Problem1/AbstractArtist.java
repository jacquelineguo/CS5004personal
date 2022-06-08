package Problem1;

import java.util.Arrays;
import java.util.Objects;

/**
 * An abstract Artist class represents an artist.
 */
public abstract class AbstractArtist implements Artist{
  private String name;
  private Integer age;
  private String[] genres;
  private String[] awards;
  private static final Integer ZERO = 0;
  private static final Integer MAX_AGE = 128;

  /**
   * Constructor for AbstractArtist class.
   * @param name - an artist's name.
   * @param age - the artist's age.
   * @param genres - an Artist’sg genres.
   * @param awards - all awards that an Artist received.
   * @throws InvalidAgeException if the age is not in range 0 to 128.
   */
  public AbstractArtist(String name, Integer age, String[] genres, String[] awards)
      throws InvalidAgeException {
    this.name = name;
    this.genres = genres;
    this.awards = awards;
    if (age >= ZERO && age <= MAX_AGE) {
      this.age = age;
    }
    else {
      throw new InvalidAgeException();
    }
  }

  /**
   * Add new award to all awards list.
   * @param award - new award.
   */
  public void receiveAward(String award) {
    Integer length = this.awards.length + 1;
    String[] newList = new String[length];
    copyItems(this.awards, newList);
    newList[length - 1] = award;
    this.awards = newList;
  }

  /**
   * Helper function copy items from awards list to new lists.
   * @param from - original awards list.
   * @param to - new list.
   */
  private void copyItems(String[] from, String[] to) {
      for (int i = 0; i < from.length; i++) {
        to[i] = from[i];
      }
  }

  /**
   * Get artist's name.
   * @return the name of the artist.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Get artist's age.
   * @return the artist's age.
   */
  public Integer getAge() {
    return this.age;
  }

  /**
   * Get genres.
   * @return genres.
   */
  public String[] getGenres() {
    return this.genres;
  }

  /**
   * Get awards list.
   * @return awards list.
   */
  public String[] getAwards() {
    return this.awards;
  }




  @Override
  public int hashCode() {
    return Objects.hash(name, age, genres, awards);
  }

  @Override
  public String toString() {
    return "AbstractArtist{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", genres=" + Arrays.toString(genres) +
        ", awards=" + Arrays.toString(awards) +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractArtist)) {
      return false;
    }
    AbstractArtist that = (AbstractArtist) o;
    return getName().equals(that.getName()) && getAge().equals(that.getAge()) && Arrays
        .equals(getGenres(), that.getGenres()) && Arrays
        .equals(getAwards(), that.getAwards());
  }
}
