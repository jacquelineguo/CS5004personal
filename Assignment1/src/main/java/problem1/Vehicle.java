package problem1;
/**
 * Vehicle is a class represents a vehicle that has a unique Vehicle Identification Number (VIN), and corresponding
 * license plate, and the owner information which includes owner's firsName, lastName and phoneNumber.
 */
public class Vehicle {
    private int VIN;
    private String licensePlate;
    private Owner owner;

    /**
     * Constructor that creates a new vehicle object with the specified VIN and * license plate and owner info.
     * @param VIN - VIN of the new Vehicle object.
     * @param licensePlate - license plate of the new Vehicle.
     * @param owner - vehicle's owner info.
     */

    public Vehicle(int VIN, String licensePlate, Owner owner) {
        this.VIN = VIN;
        this.licensePlate = licensePlate;
        this.owner = owner;
    }

    /**
     * Returns the VIN of the Vehicle.
     * * @return the VIN of the Vehicle.
     */

    public int getVIN() {
        return this.VIN;
    }

    /**
     * Returns the licensePlate of the Vehicle
     * * @return the licensePlate of the Vehicle
     */

    public String getLicensePlate() {
        return this.licensePlate;
    }

    /**
     * Returns the firstName of the Owner
     * * @return the firstName of the Owner
     */

    public String getFirstName() {
        return this.owner.getFirstName();
    }

    /**
     * Returns the lastName of the Owner
     * * @return the lastName of the Owner
     */

    public String getLastName() {
        return this.owner.getLastName();
    }

    /**
     * Returns the phoneNumber of the Owner
     * * @return the phoneNumber of the Owner
     */

    public String getPhoneNumber() {
        return this.owner.getPhoneNumber();
    }

    /**
     * Sets the VIN of the Vehicle.
     */

    public void setVIN(int VIN) {
        this.VIN = VIN;
    }

    /**
     * Sets the licensePlate of the Vehicle.
     */

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    /**
     * Sets the firstName of the Owner.
     */

    public void setFirstName(String firstName) {
        this.owner.setFirstName(firstName);
    }

    /**
     * Sets the lastName of the Owner.
     */

    public void setLastName(String lastName) {
        this.owner.setLastName(lastName);
    }

    /**
     * Sets the phoneNumber of the Owner.
     */

    public void setPhoneNumber(String phoneNumber) {
        this.owner.setPhoneNumber(phoneNumber);
    }
}
