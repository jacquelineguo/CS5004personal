package Problem1;

import java.util.Objects;

/**
 * PriorityQueue represents an immutable data structure, where every element of a PQ contains two
 * properties: a priority (Integer) and a value associated with the priority (String).
 */
public class PriorityQueue implements IPriorityQueue{

  private Element first;
  private PriorityQueue rest;

  /**
   * Constructor for PriorityQueue class.
   * @param first - first element of PriorityQueue.
   * @param rest - rest of PriorityQueue.
   */
  public PriorityQueue(Element first, PriorityQueue rest) {
    this.first = first;
    this.rest = rest;
  }

  /**
   * Helper function that can get the first element of PriorityQueue.
   * @return the first element of PriorityQueue.
   */
  private Element getFirst() {
    return this.first;
  }

  /**
   * Helper function that can get the rest of PriorityQueue.
   * @return the rest of PriorityQueue.
   */
  private PriorityQueue getRest() {
    return this.rest;
  }

  /**
   * Check if the Priority Queue is empty or not.
   * @return true if it's empty, false otherwise.
   */
  @Override
  public Boolean isEmpty() {
    return false;
  }

  /**
   * Adds the given element (the priority and its associated value) to the PQ.
   * @param priority - an Integer represents Priority Queue's priority.
   * @param value - a String represents Priority Queue's value.
   * @return a new Priority Queue with the added element.
   */
  @Override
  public PriorityQueue add(Integer priority, String value) {
    Element ele = new Element(priority, value);
    if (priority >= this.first.getPriority()) {
      return new PriorityQueue(ele, this);
    }
    else {
      return new PriorityQueue(this.first, this.rest.add(priority, value));
    }
  }

  /**
   * Find the value in the PQ that has the highest priority. If there are several same highest
   * priority, then return all values that has the same highest priority.
   * @return the value in the PQ that has the highest priority.
   * @throws PeekOnEmptyPQException if the Priority Queue is empty.
   */
  @Override
  public String peek() {
    if (this.rest != null && this.rest.getFirst().getPriority() == this.first.getPriority()) {
      return this.first.getValue() + " | " + this.rest.peek();
    }
    return this.first.getValue();
  }

  /**
   * Remove the element that has the highest priority. If there are several same highest
   * priority, then remove them all.
   * @return a copy of the PQ without the element with the highest priority.
   * @throws PopOnEmptyPQException if the Priority Queue is empty.
   */
  @Override
  public PriorityQueue pop() {
    if (this.rest != null) {
      if (this.rest.getFirst().getPriority() != this.first.getPriority()) {
        return new PriorityQueue(this.rest.getFirst(), this.rest.getRest());
      }
      return this.rest.pop();
    }
    else {
      return null;
    }
  }

  @Override
  public String toString() {
    return "PriorityQueue{" +
        "first=" + this.first +
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
    PriorityQueue that = (PriorityQueue) o;
    return Objects.equals(getFirst(), that.getFirst()) && Objects
        .equals(getRest(), that.getRest());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getFirst(), getRest());
  }
}
