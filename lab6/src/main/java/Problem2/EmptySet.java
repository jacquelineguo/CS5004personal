package Problem2;

import java.util.HashMap;

public class EmptySet  implements ISet{

  /**
   * Check if the Set is empty.
   * @return true if the set is empty, false otherwise.
   */
  public Boolean isEmpty() {
    return true;
  }

  /**
   * Add an element to the set if it's not contains the element.
   * @param n - an Integer to be add.
   */
  public ISet add(Integer n) {
    return new ConSet(n, this);
  }

  /**
   * Check if the set contains an element.
   * @param n - the element to be check.
   * @return true if it contains, false otherwise.
   */
  public Boolean contains(Integer n) {
    return false;
  }

  /**
   * Remove an element if the it's in the Set.
   * @param ele - element to be remove.
   */
  public ISet remove(Integer ele) {
    return this;
  }

  /**
   * Check the size of the Set.
   * @return the size of the Set.
   */
  public Integer size() {
    return 0;
  }

  @Override
  public String toString() {
    return "EmptySet";
  }

  @Override
  public int hashCode() {
    return 31;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || this.getClass() != obj.getClass()) return false;
    return true;
  }
}
