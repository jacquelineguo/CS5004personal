package Problem2;

import java.util.Objects;

/**
 * BagOfWords represents a multiset of its words, where we disregard grammar and the order of the
 * word. It also can has duplicate elements.
 */
public class BagOfWords implements IBagOfWords {
  private String first;
  private BagOfWords rest;
  private static final Integer ONE_BAG = 1;
  private static final Integer ZERO = 0;

  /**
   * Constructor for the BagOfWords. In the constructor, we sorted the BagOfWord alphabetically.
   * @param first - first word in the BagOfWords.
   * @param rest - rest words in the BagOfWords.
   */
  public BagOfWords(String first, BagOfWords rest) {
    if (rest != null && first.compareTo(rest.first) > ZERO) {
      this.first = rest.first;
      this.rest = rest.rest.add(first);
    }
    else {
      this.first = first.toLowerCase();
      this.rest = rest;
    }
  }

  /**
   * Check if the BagOfWords is empty.
   *
   * @return true if it's empty, false otherwise.
   */
  @Override
  public Boolean isEmpty() {
    return false;
  }

  /**
   * Get the size of the BagOfWords.
   *
   * @return the size of the BagOfWords.
   */
  @Override
  public Integer size() {
    if (this.rest != null) {
      return ONE_BAG + this.rest.size();
    }
    return ONE_BAG;
  }

  /**
   * Add a String into the BagOfWords.
   *
   * @param s - a String to be added in the BagOfWords.
   * @return a new BagOfWords that contains all elements in the original BagOfWords plus s.
   */
  @Override
  public BagOfWords add(String s) {
    String str = s.toLowerCase();
    if (this.rest == null) {
      if (this.first.compareTo(str) < ZERO) {
        BagOfWords temp = new BagOfWords(str, null);
        return new BagOfWords(this.first, temp);
      }
    }
    else {
      if (this.first.compareTo(str) < ZERO) {
        return new BagOfWords(this.first, rest.add(str));
      }
    }
    return new BagOfWords(str, this);
  }

  /**
   * Check if the BagOfWords contains a String.
   *
   * @param s -a String to be checked.
   * @return true if it's contains, false otherwise.
   */
  @Override
  public Boolean contains(String s) {
    if (this.rest != null) {
      return this.first.equals(s.toLowerCase()) || this.rest.contains(s.toLowerCase());
    }
    return this.first.equals(s.toLowerCase());
  }

  @Override
  public String toString() {
    return "BagOfWords{" +
        "first='" + this.first + '\'' +
        ", rest=" + this.rest +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    BagOfWords that = (BagOfWords) o;
    return Objects.equals(this.first, that.first) && Objects.equals(this.rest, that.rest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.first, this.rest);
  }
}
