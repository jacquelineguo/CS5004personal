package Problem1and2;

/**
 * Boat represent a boat.
 */
public class Boat extends AbstractVehicle{

  /**
   * Constructor for a Boat class.
   * @param vehicleID - boat ID.
   * @param aveSpeed - boat average speed.
   * @param maxSpeed - boat maximum speed.
   */
  public Boat(String vehicleID, Float aveSpeed, Float maxSpeed) {
    super(vehicleID, aveSpeed, maxSpeed);
  }

  @Override
  public String toString() {
    return "{Boat: " + super.toString() + "}";
  }

}
