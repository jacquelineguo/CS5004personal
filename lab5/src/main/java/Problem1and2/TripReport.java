package Problem1and2;

import java.util.Objects;

/**
 * TripReport class is used to store information about a trip made by a particular vehicle.
 */
public class TripReport {
  private AbstractVehicle vehicle;
  private Float speed;
  private Float distance;
  private Integer duration;

  /**
   * Constructor for TripReport class.
   * @param vehicle - a vehicle.
   * @param speed - vehicle's speed.
   * @param distance - distance of the trip.
   * @param duration - duration of the trip.
   */
  public TripReport(AbstractVehicle vehicle, Float speed, Float distance, Integer duration) {
    this.vehicle = vehicle;
    this. speed = speed;
    this.distance = distance;
    this.duration = duration;
  }

  /**
   * Get vehicle.
   * @return vehicle.
   */
  public AbstractVehicle getVehicle() {
    return this.vehicle;
  }

  /**
   * Get speed.
   * @return speed.
   */
  public Float getSpeed() {
    return this.speed;
  }

  /**
   * Get trip distance.
   * @return the trip distance.
   */
  public Float getDistance() {
    return this.distance;
  }

  /**
   * Get trip duration.
   * @return the trip duration.
   */
  public Integer getDuration() {
    return this.duration;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TripReport that = (TripReport) o;
    return vehicle.equals(that.vehicle)
        && speed.equals(that.speed)
        && distance.equals(that.distance)
        && duration.equals(that.duration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vehicle, speed, distance, duration);
  }

  @Override
  public String toString() {
    return "TripReport{" +
        "vehicle=" + vehicle +
        ", speed=" + speed +
        ", distance=" + distance +
        ", duration=" + duration +
        '}';
  }
}
