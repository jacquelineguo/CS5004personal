package Problem2;

/**
 * RecordingArtist represents the artist of the music.
 */
public class RecordingArtist extends AbstractIndividual{

  /**
   * Constructor of RecordingArtist.
   * @param firstName - artist's first name.
   * @param lastName - artist's last name.
   */
  public RecordingArtist(String firstName, String lastName) {
    super(firstName, lastName);
  }

  @Override
  public String toString() {
    return "RecordingArtist{" +
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
