package Problem1;

/**
 * Represents the empty list of integers.
 */


public class Empty implements List {

    @Override
    public Integer size() {
        return 0;
    }

    @Override
    public Boolean isEmpty() {
        return true;
    }

    @Override
    public List add(Integer element) {
        return new Cons(element, this);
    }

    @Override
    public Integer last() throws InvalidCallException {
        throw new InvalidCallException("Called last() on empty!");
    }

    /**
     * Check if the list contains an element.
     * @param element the element to check.
     * @return true if element is in the list and false otherwise.
     */
    @Override
    public Boolean contains(Integer element) {
        return false;
    }

    /**
     * Find the element in provided index.
     * @param index - index of the element.
     * @return the element found at index in the list.
     */
    @Override
    public Integer elementAt(Integer index) {
        throw new InvalidCallException("Call elementAt() on empty!");
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        else return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return 42;
    }

    @Override
    public String toString() {
        return "Empty{}";
    }
}
