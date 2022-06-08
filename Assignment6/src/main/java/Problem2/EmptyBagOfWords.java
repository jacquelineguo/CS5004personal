package Problem2;

/**
 * EmptyBagOfWords represents an empty EmptyBagOfWords.
 */
public class EmptyBagOfWords implements IBagOfWords {
  private static final Integer EMPTY = 0;
  private static final Integer HASH = 31;

  /**
   * Constructor for the EmptyBagOfWords.
   */
  public EmptyBagOfWords() {
  }

  /**
   * Check if the BagOfWords is empty.
   *
   * @return true if it's empty, false otherwise.
   */
  @Override
  public Boolean isEmpty() {
    return true;
  }

  /**
   * Get the size of the BagOfWords.
   *
   * @return the size of the BagOfWords.
   */
  @Override
  public Integer size() {
    return EMPTY;
  }

  /**
   * Add a String into the BagOfWords.
   *
   * @param s - a String to be added in the BagOfWords.
   * @return a new BagOfWords that contains all elements in the original BagOfWords plus s.
   */
  @Override
  public BagOfWords add(String s) {
    return new BagOfWords(s, null);
  }

  /**
   * Check if the BagOfWords contains a String.
   *
   * @param s -a String to be checked.
   * @return true if it's contains, false otherwise.
   */
  @Override
  public Boolean contains(String s) {
    return false;
  }

  @Override
  public String toString() {
    return "EmptyBagOfWords{}";
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || this.getClass() != obj.getClass()) return false;
    return true;
  }

  @Override
  public int hashCode() {
    return HASH;
  }
}
