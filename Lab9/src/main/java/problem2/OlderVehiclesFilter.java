package problem2;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * OlderVehiclesFilter class represents a filter that can help filter the vehicles' year later than
 * 1999.
 */
public class OlderVehiclesFilter {
  private List<Vehicle> vehicles = new ArrayList<>();
  private static final Integer YEAR_BOUND = 1999;

  /**
   * Constructor for OlderVehiclesFilter class.
   * @param vehicles - a list of vehicles.
   */
  public OlderVehiclesFilter(List<Vehicle> vehicles) {
    this.vehicles = vehicles;
  }

  /**
   * Constructor for OlderVehiclesFilter class.
   * @param vehicle1 - first vehicle to be filter.
   * @param vehicle2 - second vehicle to be filter.
   * @param vehicle3 - third vehicle to be filter.
   */
  public OlderVehiclesFilter(Vehicle vehicle1, Vehicle vehicle2, Vehicle vehicle3){
    this.vehicles.add(vehicle1);
    this.vehicles.add(vehicle2);
    this.vehicles.add(vehicle3);
  }

  /**
   * Filter a list of vehicles that the make year is later than 1999, and return their make, model,
   * and year as a String of List.
   * @return return their make, model, and year as a String of List.
   */
  public List<String> filterVWVehicles(){
    //YOUR CODE HERE
    return this.vehicles.stream().
        filter(vehicle -> vehicle.getYear() > YEAR_BOUND).
        flatMap(vehicle ->
            Stream.of(vehicle.getMake(), vehicle.getModel(), vehicle.getYear().toString())).
        collect(Collectors.toList());
  }
}