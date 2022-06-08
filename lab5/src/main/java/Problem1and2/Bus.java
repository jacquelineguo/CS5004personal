package Problem1and2;

/**
 * Bus represent a bus.
 */
public class Bus extends AbstractVehicle{

  /**
   * Constructor for a Bus class.
   * @param vehicleID - bus ID.
   * @param aveSpeed - bus average speed.
   * @param maxSpeed - bus maximum speed.
   */
  public Bus(String vehicleID, Float aveSpeed, Float maxSpeed) {
    super(vehicleID, aveSpeed, maxSpeed);
  }

  @Override
  public String toString() {
    return "{Bus: " + super.toString() + "}";
  }
}
