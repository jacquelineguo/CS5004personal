package problem1;
/**
 * Owner is a class represents an vehicle owner that has a unique firstName, lastName, and phoneNumber.
 */
public class Owner {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    /**
     * Constructor that creates a new owner object with the specified firstName, lastName, and phoneNumber.
     * @param firstName - first name of a vehicle owner.
     * @param lastName - last name of a vehicle owner.
     * @param phoneNumber - phone number of a vehicle owner.
     */

    public Owner(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns the firstName of the Owner.
     * * @return the firstName of the Owner.
     */

    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Returns the lastName of the Owner.
     * * @return the lastName of the Owner.
     */

    public String getLastName() {
        return this.lastName;
    }

    /**
     * Returns the phoneNumber of the Owner.
     * * @return the phoneNumber of the Owner.
     */

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Sets the firstName of the Vehicle.
     */

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the lastName of the Vehicle.
     */

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the phoneNumber of the Vehicle.
     */

    public void setPhoneNumber(String phoneNumber) {
        int LEN = 10;
        if (phoneNumber.length() == LEN) {
            this.phoneNumber = phoneNumber;
        }
        else {
            System.out.println("Wrong phone number entered!");
            this.phoneNumber = "0000000000";
        }
    }
}
