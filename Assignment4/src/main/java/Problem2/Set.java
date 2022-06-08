package Problem2;

import java.util.Arrays;
import java.util.Objects;

/**
 * Set class, as in the mathematical notion of a set.
 */
public class Set implements ISet{
  private static final Integer NUM_SLOTS = 1;
  private static final Integer EMPTY = 0;
  private Integer[] arr;
  private Integer size;

  /**
   * Constructor for Set class.
   */
  public Set() {
    this.size = 0;
    this.arr = new Integer[NUM_SLOTS];
  }

  /**
   * Constructor for Set class.
   * @param arr - an Integer array.
   */
  public Set(Integer[] arr) {
    this.size = arr.length;
    this.arr = arr;
  }

  /**
   * Creat an empty Set.
   * @return an empty Set.
   */
  public Set emptySet() {
    return new Set();
  }

  /**
   * Check if the Set is empty.
   * @return true if the set is empty, false otherwise.
   */
  public Boolean isEmpty(){
    return this.size == EMPTY;
  }

  /**
   * Adds the given Integer to the Set if and only if that Integer is not already in the Set.
   * @param n - an Integer.
   * @return a new Set if not contain, return the original Set if already in the Set.
   */
  public Set add(Integer n) {
    if (!this.contains(n)) {
      int newSize = this.size + NUM_SLOTS;
      Integer[] newArr = new Integer[newSize];
      this.copyItems(this.arr, newArr);
      newArr[newSize - 1] = n;
      Set newSet = new Set(newArr);
      newSet.size = newSize;
      return newSet;
    }
    return this;
  }

  /**
   * Helper function used by add and insert methods. Copies the items from one array to another.
   * @param from The array to copy from.
   * @param to The array to copy to.
   * @param fromStart The index in the "from" array to start copying from.
   * @param fromEnd The index in the "from" array to end at (exclusive).
   * @param toStart The index in the "to" array to start copying to.
   */
  private void copyItems(Integer[] from, Integer[] to, int fromStart, int fromEnd, int toStart) {
    if (toStart >= 0) {
      for (int i = fromStart; i < fromEnd; i++) {
        to[toStart] = from[i];
        toStart++;
      }
    }
  }

  /**
   * Shortcut version of the helper method above. Will copy the entirety of the "from" array to the
   * "to" array.
   * @param from The array to copy from.
   * @param to The array to copy to.
   */
  private void copyItems(Integer[] from, Integer[] to) {
    this.copyItems(from, to, 0, from.length, 0);
  }

  /**
   * Check if the Set contains an Integer.
   * @param n - an Integer.
   * @return true if the given Integer is in the Set, false otherwise.
   */
  public Boolean contains(Integer n) {
    int i;
    for (i = 0; i < this.arr.length; i++) {
      if (arr[i] == n) {
        return true;
      }
    }
    return false;
  }

  /**
   * Remove an Integer in the Set.
   * @param n - an Integer.
   * @return a copy of the Set with the given Integer removed. If the given Integer is not in the
   * Set, returns the Set as is.
   */
  public Set remove(Integer n) {
    Integer i;
    if (!this.contains(n)) {
      return this;
    }
    Integer[] arr = new Integer[this.arr.length - 1];
    for (i = 0; i < this.arr.length; i++) {
      if (i < findIndex(n)) {
        arr[i] = this.arr[i];
      }
      else if (i == findIndex(n)) {
        continue;
      }
      else {
        arr[i - 1] = this.arr[i];
      }
    }
    Set newSet = new Set(arr);
    newSet.size = this.size - 1;
    return newSet;
  }

  /**
   * Helper function to find the index if the Integer is in the Set.
   * @param n - an Integer.
   * @return the index if the Integer is in the Set, -1 if it's not.
   */
  private Integer findIndex(Integer n) {
    for (int i = 0; i < this.arr.length; i++) {
      if (this.arr[i] == n) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Find the size of the Set.
   * @return the size.
   */
  public Integer size() {
    return this.size;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Set)) {
      return false;
    }
    Set set1 = (Set) o;
    Arrays.sort(this.arr);
    Arrays.sort(set1.arr);
    return Arrays.equals(this.arr, set1.arr) && Objects.equals(size, set1.size);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(size);
    result = 31 * result + Arrays.hashCode(arr);
    return result;
  }

  @Override
  public String toString() {
    return "Set{" +
        "set=" + Arrays.toString(arr) +
        ", size=" + size +
        '}';
  }
}
