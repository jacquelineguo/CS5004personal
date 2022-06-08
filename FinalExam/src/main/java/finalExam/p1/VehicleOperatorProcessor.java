package finalExam.p1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleOperatorProcessor {
  private List<VehicleOperator> operators;
  private static final Integer CHECK_BOUND = 1;
  private static final Integer ZERO = 0;

  public VehicleOperatorProcessor(List<VehicleOperator> operators) {
    this.operators = operators;
  }

  private VehicleOperatorProcessor(VehicleOperator operator1, VehicleOperator operator2){
    this.operators.add(operator1);
    this.operators.add(operator2);
  }

  /**
   * Filter the vehicles in the operated vehicles list of given operator in the VehicleOperator
   * class with requested make and model.
   * @param operator - the given VehicleOperator class which contains the field of operatedVehicles
   *                 as a list of Vehicles.
   * @param make - Vehicle make which is a String.
   * @param model - Vehicle model which is a String.
   * @return a list of Vehicles that has same Vehicle make and model as requested.
   */
  public static List<Vehicle> mysteryMethod(VehicleOperator operator, String make, String model){
    return operator.getOperatedVehicles().stream()
        .filter(x -> x.getMake().equals(make) && x.getModel().equals(model))
        .collect(Collectors.toList());
  }

  /**
   * Get the list of names of all VehicleOperators who operate at least one vehicle older than or
   * equal to the input argument manufacturingYear.
   * @param manufacturingYear - manufacturing year of a vehicle as the LocalDate.
   * @return the list of names of all VehicleOperators who operate at least one vehicle older than
   * or equal to the input argument manufacturingYear.
   */
  public List<String> filterByManufacturingYear(LocalDate manufacturingYear){
    return this.operators.stream().
        filter(operator -> this.containsVehicleOlderThan(operator, manufacturingYear)).
        map(VehicleOperator::getName).collect(Collectors.toList());
  }

  /**
   * Helper method that helps check if a VehicleOperator who operate at least one vehicle older
   * than or equal to the input argument manufacturingYear.
   * @param operator - a VehicleOperator who operate a list of Vehicles.
   * @param manufacturingYear - manufacturing year of a vehicle as the LocalDate.
   * @return true if the VehicleOperator operate at least one Vehicle that older than the given
   * manufacturingYear, false otherwise.
   */
  private boolean containsVehicleOlderThan(VehicleOperator operator, LocalDate manufacturingYear) {
    return operator.getOperatedVehicles().stream().
        filter(vehicle -> vehicle.getYearManufactured().
            compareTo(manufacturingYear) >= ZERO).count() >= CHECK_BOUND;
  }
}
