package Problem1;

/**
 * Represents a photographer.
 */
public class Photographer extends AbstractVisualArtist{

  /**
   * Constructor of Photographer class.
   * @param name - an artist's name.
   * @param age - the artist's age.
   * @param genres - an Artist’sg genres.
   * @param awards - all awards that an Artist received.
   * @param exhibits - all exhibits where the artist art was show.
   * @throws InvalidAgeException - if the age is not in range 0 to 128.
   */
  public Photographer(String name, Integer age, String[] genres, String[] awards, String[] exhibits)
      throws InvalidAgeException {
    super(name, age, genres, awards, exhibits);
  }

  @Override
  public boolean equals(Object o) {
    return super.equals(o);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public String toString() {
    return "Photographer: " + super.toString();
  }

}
