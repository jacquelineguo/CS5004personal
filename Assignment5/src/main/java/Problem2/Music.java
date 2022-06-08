package Problem2;

/**
 * Music represent a music.
 */
public class Music extends AbstractItems{

  /**
   * Constructor of Music.
   * @param artist - music artist.
   * @param title - title of music.
   * @param releaseYear - release year as an integer.
   */
  public Music(RecordingArtist artist, String title, int releaseYear) {
    super(artist, title, releaseYear);
  }

  /**
   * Constructor of Music.
   * @param band - band of music.
   * @param title - title of music.
   * @param releaseYear - release year as an integer.
   */
  public Music(Band band, String title, int releaseYear) {
    super(band, title, releaseYear);
  }

  /**
   * Check whether music contains the creator.
   * @param creator - the item creator.
   * @return true if contains, false otherwise.
   */
  @Override
  public boolean matchCreator(ICreators creator) {
    return this.creator.isCreatorEqual(creator);
  }

  @Override
  public String toString() {
    return "Music{" +
        "creator=" + creator +
        ", title='" + title + '\'' +
        ", releaseYear=" + releaseYear +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    return super.equals(o);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
