package Problem1;

/**
 * Represents a List of Integers
 */
public interface List {

    /**
     * Returns the total number of elements in the list.
     *
     * @return number of elements in this list
     */
    Integer size();


    /**
     * Returns true if empty and false otherwise
     *
     */
    Boolean isEmpty();

    /**
     * Given a new element {@code element} prepend it to this list
     *
     * @param element new element to add to the list
     * @return updated list with {@code element} prependeds
     */
    List add(Integer element);


    /**
     * Return the last element of this list.
     *
     * @return the last element of this list.
     */
    Integer last();

    /**
     * Check if the list contains an element.
     * @param element the element to check.
     * @return true if element is in the list and false otherwise.
     */
    Boolean contains(Integer element);

    /**
     * Find the element in provided index.
     * @param index - index of the element.
     * @return the element found at index in the list.
     */
    Integer elementAt(Integer index);
}
