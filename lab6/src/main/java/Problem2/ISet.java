package Problem2;

public interface ISet {
  static ISet emptySet() {
    return new EmptySet();
  }

  /**
   * Check if the Set is empty.
   * @return true if the set is empty, false otherwise.
   */
  Boolean isEmpty();

  /**
   * Add an element to the set if it's not contains the element.
   * @param n - an Integer to be add.
   */
  ISet add(Integer n);

  /**
   * Check if the set contains an element.
   * @param n - the element to be check.
   * @return true if it contains, false otherwise.
   */
  Boolean contains(Integer n);

  /**
   * Remove an element if the it's in the Set.
   * @param ele - element to be remove.
   */
  ISet remove(Integer ele);

  /**
   * Check the size of the Set.
   * @return the size of the Set.
   */
  Integer size();
}
