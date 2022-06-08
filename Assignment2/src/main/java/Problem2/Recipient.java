package Problem2;

/**
 * A Recipient class representing a mail recipient with first name, last name, and email address.
 */
public class Recipient {
  private String firstName;
  private String lastName;
  private String address;

  /**
   * Constructor for Recipient class.
   * @param firstName - recipient's first name.
   * @param lastName - recipient's last name.
   * @param address - recipient's email address.
   */
  public Recipient(String firstName, String lastName, String address) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
  }

  /**
   * Get first name.
   * @return the recipient's first name.
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Get last name.
   * @return the recipient's last name.
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * Get name.
   * @return the recipient's full name.
   */
  public String getName() {
    return this.firstName + " " + this.lastName;
  }

  /**
   * Get email address.
   * @return the recipient's email address.
   */
  public String getAddress() {
    return this.address;
  }
 }
