package Problem1;

import java.util.Arrays;
import java.util.Objects;

/**
 * Represents AbstractFilmArtist class.
 */
public abstract class AbstractFilmArtist extends AbstractArtist{
  private String[] movies;
  private String[] series;
  private String[] multimedia;

  /**
   * Constructor of AbstractFilmArtist class.
   * @param name - an artist's name.
   * @param age - the artist's age.
   * @param genres - an Artist’sg genres.
   * @param awards - all awards that an Artist received.
   * @param movies - all movies that the artist worked on.
   * @param series - all TV series that the artist worked on.
   * @param multimedia - all other multimedia contents the artist worked on.
   * @throws InvalidAgeException - if the age is not in range 0 to 128.
   */
  public AbstractFilmArtist(String name, Integer age, String[] genres, String[] awards,
      String[] movies, String[] series, String[] multimedia)
      throws InvalidAgeException {
    super(name, age, genres, awards);

    this.movies = movies;
    this.series = series;
    this.multimedia = multimedia;
  }

  /**
   * Get movies.
   * @return all movies that the artist worked on.
   */
  public String[] getMovies() {
    return this.movies;
  }

  /**
   * Get series.
   * @return all TV series that the artist worked on.
   */
  public String[] getSeries() {
    return this.series;
  }

  /**
   * Get multimedia.
   * @return all other multimedia contents the artist worked on.
   */
  public String[] getMultimedia() {
    return this.multimedia;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractFilmArtist)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    AbstractFilmArtist that = (AbstractFilmArtist) o;
    return Arrays.equals(this.movies, that.movies) &&
        Arrays.equals(this.series, that.series) &&
        Arrays.equals(this.multimedia, that.multimedia);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), movies, series, multimedia);
  }

  @Override
  public String toString() {
    return "AbstractFilmArtist{" + super.toString() +
        ", movies=" + Arrays.toString(movies) +
        ", series=" + Arrays.toString(series) +
        ", multimedia=" + Arrays.toString(multimedia) +
        '}';
  }
}
