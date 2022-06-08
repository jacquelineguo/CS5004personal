package Problem2;

/**
 * A List represents a Set, immutable collection of a mathematical set.
 */
public interface ISet {

  /**
   * Creat an empty Set.
   * @return an empty Set.
   */
  Set emptySet();

  /**
   * Check if the Set is empty.
   * @return true if the set is empty, false otherwise.
   */
  Boolean isEmpty();

  /**
   * Adds the given Integer to the Set if and only if that Integer is not already in the Set.
   * @param n - an Integer.
   * @return a new Set if not contain, return the original Set if already in the Set.
   */
  Set add(Integer n);

  /**
   * Check if the Set contains an Integer.
   * @param n - an Integer.
   * @return true if the given Integer is in the Set, false otherwise.
   */
  Boolean contains(Integer n);

  /**
   * Remove an Integer in the Set.
   * @param n - an Integer.
   * @return a copy of the Set with the given Integer removed. If the given Integer is not in the
   * Set, returns the Set as is.
   */
  Set remove(Integer n);

  /**
   * Find the size of the Set.
   * @return the size.
   */
  Integer size();

}
