package Problem1;

/**
 * An interface specifying behavior for an artist.
 */
public interface Artist {

  /**
   * Add award to awards list.
   * @param award - new award.
   */
  void receiveAward(String award);

  /**
   * Get name.
   * @return artist's name.
   */
  String getName();

  /**
   * Get age.
   * @return artist's age.
   */
  Integer getAge();


  /**
   * Get genres.
   * @return genres.
   */
  String[] getGenres();

  /**
   * Get awards list.
   * @return awards list.
   */
  String[] getAwards();

  /**
   * Test the equality of another object to this artist.
   * @param obj the object to test
   * @return true if equal, else false
   */
  boolean equals(Object obj);

  /**
   * Generates a hashcode for this artist.
   * @return a hashcode
   */
  int hashCode();

  /**
   * Generates a string representation of the artist.
   * @return a string representation of this artist
   */
  String toString();
}
