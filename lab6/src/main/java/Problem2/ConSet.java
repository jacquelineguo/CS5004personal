package Problem2;

import java.util.Objects;

public class ConSet implements ISet{
  private Integer first;
  private ISet rest;

  /**
   * Constructor of ConSet.
   * @param first - first element in the ConSet.
   * @param rest - rest elements of ConSet.
   */
  public ConSet(Integer first, ISet rest) {
    this.first = first;
    this.rest = rest;
  }

  /**
   * Check if the Set is empty.
   * @return true if the set is empty, false otherwise.
   */
  public Boolean isEmpty() {
    return false;
  }

  /**
   * Add an element to the set if it's not contains the element.
   * @param n - an Integer to be add.
   */
  public ISet add(Integer n) {
    if (this.contains(n)) {
      return this;
    }
    else {
      return new ConSet(n, this);
    }
  }

  /**
   * Check if the set contains an element.
   * @param n - the element to be check.
   * @return true if it contains, false otherwise.
   */
  public Boolean contains(Integer n) {
    return this.first == n || this.rest.contains(n);
  }

  /**
   * Remove an element if the it's in the Set.
   * @param ele - element to be remove.
   */
  public ISet remove(Integer ele) {
    if (!this.contains(ele)) return this;

    if (this.first.equals(ele)) {
      return this.rest;
    }
    else {
      return new ConSet(this.first, this.rest.remove(ele));
    }
  }

  /**
   * Check the size of the Set.
   * @return the size of the Set.
   */
  public Integer size() {
    return 1 + this.rest.size();
  }

  @Override
  public String toString() {
    return "ConSet{" +
        "first=" + first +
        ", rest=" + rest +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConSet conSet = (ConSet) o;

    if (!this.size().equals(conSet.size())) return false;
    if (!conSet.contains(this.first)) return false;

    return this.rest.equals(conSet.remove(this.first));
  }

  @Override
  public int hashCode() {
    int result = 31 * this.size();
    result += Objects.hashCode(this.first);
    return result + this.rest.hashCode();
  }
}
