package finalExam.p3;

import java.util.List;
import java.util.Objects;

/**
 * Class represents a guest, who is a restaurant customer. The guest has a first name, last name and a
 * list of restaurants they visited in the last year.
 */
class Guest {
  private String firstName;
  private String lastName;
  private List<Restaurant> visitedRestaurant;


  /**
   * Constructs a Customer object and initializes it
   * to the given first name, last name and the list of bought products
   * @param firstName the first name of this person
   * @param lastName the last name of this person
   * @param visitedRestaurant list of restaurants they visited in the last year.
   */

  public Guest(String firstName, String lastName, List<Restaurant> visitedRestaurant) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.visitedRestaurant = visitedRestaurant;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public List<Restaurant> getVisitedRestaurant() {
    return visitedRestaurant;
  }

  @Override
  public String toString() {
    return "Guest{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", visitedRestaurant=" + visitedRestaurant +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Guest)) {
      return false;
    }
    Guest guest = (Guest) o;
    return Objects.equals(getFirstName(), guest.getFirstName()) && Objects
        .equals(getLastName(), guest.getLastName()) && Objects
        .equals(getVisitedRestaurant(), guest.getVisitedRestaurant());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getFirstName(), getLastName(), getVisitedRestaurant());
  }
}

