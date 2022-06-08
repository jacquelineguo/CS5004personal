package Problem1;

/**
 * A priority queue is an immutable data structure, where every element of a PQ contains two
 * properties: a priority (Integer) and a value associated with the priority (String).
 */
public interface IPriorityQueue {

  /**
   * Creat an Empty Priority Queue.
   * @return an Empty Priority Queue.
   */
  static EmptyPriorityQueue creatEmpty() {
    return new EmptyPriorityQueue();
  }

  /**
   * Check if the Priority Queue is empty or not.
   * @return true if it's empty, false otherwise.
   */
  Boolean isEmpty();

  /**
   * Adds the given element (the priority and its associated value) to the PQ.
   * @param priority - an Integer represents Priority Queue's priority.
   * @param value - a String represents Priority Queue's value.
   * @return a new Priority Queue with the added element.
   */
  PriorityQueue add(Integer priority, String value);

  /**
   * Find the value in the PQ that has the highest priority. If there are several same highest
   * priority, then return all values that has the same highest priority.
   * @return the value in the PQ that has the highest priority.
   * @throws PeekOnEmptyPQException if the Priority Queue is empty.
   */
  String peek() throws PeekOnEmptyPQException;

  /**
   * Remove the element that has the highest priority. If there are several same highest
   * priority, then remove them all.
   * @return a copy of the PQ without the element with the highest priority.
   * @throws PopOnEmptyPQException if the Priority Queue is empty.
   */
  PriorityQueue pop() throws PopOnEmptyPQException;
}
