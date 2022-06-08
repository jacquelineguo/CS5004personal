package Problem1and2;

import java.util.Objects;

/**
 * AbstractVehicle represents an abstract class of vehicle.
 */

public abstract class AbstractVehicle {
  private String vehicleID;
  private Float aveSpeed;
  private Float maxSpeed;

  /**
   * Constructor for AbstractVehicle class.
   * @param vehicleID - vehicle ID.
   * @param aveSpeed - vehicle average speed.
   * @param maxSpeed - vehicle maximum speed.
   */
  public AbstractVehicle(String vehicleID, Float aveSpeed, Float maxSpeed) {
    this.vehicleID = vehicleID;
    this.aveSpeed = aveSpeed;
    this.maxSpeed = maxSpeed;
  }

  /**
   * Get vehicle ID.
   * @return vehicle ID.
   */
  public String getVehicleID() {
    return this.vehicleID;
  }

  /**
   * Get vehicle average speed.
   * @return vehicle average speed.
   */
  public Float getAveSpeed() {
    return this.aveSpeed;
  }

  /**
   * Get vehicle maximum speed.
   * @return vehicle maximum speed.
   */
  public Float getMaxSpeed() {
    return this.maxSpeed;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbstractVehicle vehicle = (AbstractVehicle) o;
    return vehicleID.equals(vehicle.vehicleID)
        && aveSpeed.equals(vehicle.aveSpeed)
        && maxSpeed.equals(vehicle.maxSpeed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getVehicleID(), getAveSpeed(), getMaxSpeed());
  }

  @Override
  public String toString() {
    return "AbstractVehicle{" +
        "vehicleID='" + vehicleID + '\'' +
        ", aveSpeed=" + aveSpeed +
        ", maxSpeed=" + maxSpeed +
        '}';
  }
}
