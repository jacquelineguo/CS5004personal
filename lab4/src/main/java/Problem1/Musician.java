package Problem1;

import java.util.Objects;

/**
 * A Musician class represents a musician.
 */
public class Musician extends AbstractArtist{
  private String recordingCompany;
  private String lastAlbum;

  /**
   * Constructor of the Musician class.
   * @param name - an artist's name.
   * @param age - the artist's age.
   * @param genres - an Artist’sg genres.
   * @param awards - all awards that an Artist received.
   * @param recordingCompany - representing a Musician’s recording company.
   * @param lastAlbum - representing the title of thel atest recorded album.
   * @throws InvalidAgeException if the age is not in range 0 to 128.
   */
  public Musician(String name, Integer age, String[] genres, String[] awards,
      String recordingCompany, String lastAlbum) throws InvalidAgeException {
    super(name, age, genres, awards);

    this.recordingCompany = recordingCompany;
    this.lastAlbum = lastAlbum;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Musician)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Musician musician = (Musician) o;
    return Objects.equals(recordingCompany, musician.recordingCompany) && Objects
        .equals(lastAlbum, musician.lastAlbum);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.recordingCompany, this.lastAlbum);
  }

  @Override
  public String toString() {
    return "Musician: " + super.toString() +
        ", recordingCompany='" + this.recordingCompany + '\'' +
        ", lastAlbum='" + this.lastAlbum + '\'' +
        '}';
  }

  public String getRecordingCompany() {
    return this.recordingCompany;
  }

  public String getLastAlbum() {
    return this.lastAlbum;
  }
}
