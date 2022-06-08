package Problem1and2;

/**
 * FleetManager class contains a single method drive.
 */
public class FleetManager {

  /**
   * Return a TripReport class.
   * @param distance - trip distance.
   * @param vehicle - vehicle of the trip.
   * @return a TripReport class.
   */
  public TripReport drive(float distance, AbstractVehicle vehicle) {
    return new TripReport(vehicle, vehicle.getAveSpeed(), distance,
        (int) (distance / vehicle.getAveSpeed()));
  }

  /**
   * Return a TripReport class.
   * @param distance - trip distance.
   * @param boat - boat of the trip.
   * @return a TripReport class.
   */
  public TripReport drive(float distance, Boat boat) {
    return new TripReport(boat, boat.getAveSpeed(), distance,
        (int) (distance / boat.getAveSpeed()));
  }

  /**
   * Return a TripReport class.
   * @param distance - trip distance.
   * @param bus - bus of the trip.
   * @return a TripReport class.
   */
  public TripReport drive(float distance, Bus bus) {
    return new TripReport(bus, bus.getAveSpeed(), distance,
        (int) (distance / bus.getAveSpeed()));
  }

  /**
   * Return a TripReport class.
   * @param distance - trip distance.
   * @param train - train of the trip.
   * @return a TripReport class.
   */
  public TripReport drive(float distance, Train train) {
    return new TripReport(train, train.getAveSpeed(), distance,
        (int) (distance / train.getAveSpeed()));
  }

  /**
   * Return a TripReport class.
   * @param distance - trip distance.
   * @param vehicle - vehicle of the trip.
   * @param speed - vehicle speed, if the speed larger than the maximum speed, then return maximum
   *              speed.
   * @return - a TripReport class.
   */
  public TripReport drive(float distance, AbstractVehicle vehicle, float speed) {
    if (speed > vehicle.getMaxSpeed()) {
      speed = vehicle.getMaxSpeed();
    }
    return new TripReport(vehicle, speed, distance, (int) (distance / speed));
  }
}
