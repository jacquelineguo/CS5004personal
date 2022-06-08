package Problem1;

import java.util.Objects;

/**
 * Element class represents the element in the Priority Queue.
 */
public class Element {

  private Integer priority;
  private String value;

  /**
   * Constructor of Element class.
   * @param priority - an Integer represents the Priority Queue's priority.
   * @param value - a String represents Priority Queue's value.
   */
  public Element(Integer priority, String value) {
    this.priority = priority;
    this.value = value;
  }

  /**
   * Get the priority of Priority Queue's element.
   * @return the priority of Priority Queue's element.
   */
  public Integer getPriority() {
    return this.priority;
  }

  /**
   * Get the value of Priority Queue's element.
   * @return the value of Priority Queue's element.
   */
  public String getValue() {
    return this.value;
  }

  @Override
  public String toString() {
    return "Element{" +
        "priority=" + this.priority +
        ", value='" + this.value + '\'' +
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
    Element element = (Element) o;
    return Objects.equals(getPriority(), element.getPriority()) && Objects
        .equals(getValue(), element.getValue());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getPriority(), getValue());
  }
}
