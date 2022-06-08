package Problem1;

/**
 * EmptyPriorityQueue class represent an empty PriorityQueue.
 */
public class EmptyPriorityQueue implements IPriorityQueue{
  private static final Integer HASH = 31;

  /**
   * Constructor for EmptyPriorityQueue.
   */
  public EmptyPriorityQueue() {
  }

  /**
   * Check if the Priority Queue is empty or not.
   * @return true if it's empty, false otherwise.
   */
  @Override
  public Boolean isEmpty() {
    return true;
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
    return new PriorityQueue(ele, null);
  }

  /**
   * Find the value in the PQ that has the highest priority. If there are several same highest
   * priority, then return all values that has the same highest priority.
   * @return the value in the PQ that has the highest priority.
   * @throws PeekOnEmptyPQException if the Priority Queue is empty.
   */
  @Override
  public String peek() throws PeekOnEmptyPQException{
    throw new PeekOnEmptyPQException();
  }

  /**
   * Remove the element that has the highest priority. If there are several same highest
   * priority, then remove them all.
   * @return a copy of the PQ without the element with the highest priority.
   * @throws PopOnEmptyPQException if the Priority Queue is empty.
   */
  @Override
  public PriorityQueue pop() throws PopOnEmptyPQException{
    throw new PopOnEmptyPQException();
  }

  @Override
  public String toString() {
    return "EmptyPriorityQueue";
  }

  @Override
  public int hashCode() {
    return HASH;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null || this.getClass() != obj.getClass())
      return false;
    return true;
  }
}
