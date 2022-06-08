package Problem1;

/**
 * The Filmmaker class represents a filmmaker.
 */
public class Filmmaker extends AbstractFilmArtist{

  /**
   * Constructor of Filmmaker class.
   * @param name - an artist's name.
   * @param age - the artist's age.
   * @param genres - an Artist’sg genres.
   * @param awards - all awards that an Artist received.
   * @param movies - all movies that the artist worked on.
   * @param series - all TV series that the artist worked on.
   * @param multimedia - all other multimedia contents the artist worked on.
   * @throws InvalidAgeException - if the age is not in range 0 to 128.
   */
  public Filmmaker(String name, Integer age, String[] genres, String[] awards, String[] movies,
      String[] series, String[] multimedia) throws InvalidAgeException {
    super(name, age, genres, awards, movies,series, multimedia);
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
    return "Filmmaker: " + super.toString();
  }

}
