package Problem2;

/**
 * BagOfWords represents a multiset of its words, where we disregard grammar and the order of the
 * word. It also can has duplicate elements.
 */
public interface IBagOfWords {

  /**
   * Creat an empty BagOfWords.
   * @return an empty BagOfWords.
   */
  static EmptyBagOfWords emptyBagOfWords() {
    return new EmptyBagOfWords();
  }

  /**
   * Check if the BagOfWords is empty.
   * @return true if it's empty, false otherwise.
   */
  Boolean isEmpty();

  /**
   * Get the size of the BagOfWords.
   * @return the size of the BagOfWords.
   */
  Integer size();

  /**
   * Add a String into the BagOfWords.
   * @param s - a String to be added in the BagOfWords.
   * @return a new BagOfWords that contains all elements in the original BagOfWords plus s.
   */
  BagOfWords add(String s);

  /**
   * Check if the BagOfWords contains a String.
   * @param s -a String to be checked.
   * @return true if it's contains, false otherwise.
   */
  Boolean contains(String s);
}
