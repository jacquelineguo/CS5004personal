package Problem1and2;

/**
 * Train represent a train.
 */
public class Train extends AbstractVehicle{

  /**
   * Constructor for a Train class.
   * @param vehicleID - train ID.
   * @param aveSpeed - train average speed.
   * @param maxSpeed - train maximum speed.
   */
  public Train(String vehicleID, Float aveSpeed, Float maxSpeed) {
    super(vehicleID, aveSpeed, maxSpeed);
  }

  @Override
  public String toString() {
    return "{Train: " + super.toString() + "}";
  }
}
