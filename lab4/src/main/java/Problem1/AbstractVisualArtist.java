package Problem1;

import java.util.Arrays;
import java.util.Objects;

/**
 * An AbstractPainters class represents a painter.
 */
public abstract class AbstractVisualArtist extends AbstractArtist{
  private String[] exhibits;

  /**
   * Constructor of AbstractPainters class.
   * @param name - an artist's name.
   * @param age - the artist's age.
   * @param genres - an Artist’sg genres.
   * @param awards - all awards that an Artist received.
   * @param exhibits - all exhibits where the artist art was show.
   * @throws InvalidAgeException - if the age is not in range 0 to 128.
   */
  public AbstractVisualArtist(String name, Integer age, String[] genres, String[] awards,
      String[] exhibits) throws InvalidAgeException {
    super(name, age, genres, awards);

    this.exhibits = exhibits;
  }

  /**
   * Get exhibits.
   * @return all exhibits where the artist art was show.
   */
  public String[] getExhibits() {
    return this.exhibits;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractVisualArtist)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    AbstractVisualArtist that = (AbstractVisualArtist) o;
    return Arrays.equals(getExhibits(), that.getExhibits());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), exhibits);
  }

  @Override
  public String toString() {
    return "AbstractVisualArtist{" + super.toString() +
        ", exhibits=" + Arrays.toString(exhibits) +
        '}';
  }
}
