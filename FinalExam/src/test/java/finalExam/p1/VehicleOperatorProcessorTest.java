package finalExam.p1;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class VehicleOperatorProcessorTest {
  Vehicle v1;
  Vehicle v2;
  Vehicle v3;
  Vehicle v4;
  Vehicle v5;
  List<Vehicle> vehicleList1;
  List<Vehicle> vehicleList2;
  VehicleOperator operator1;
  VehicleOperator operator2;
  VehicleOperator operator3;
  List<VehicleOperator> operatorList;
  VehicleOperatorProcessor processor1;

  @Before
  public void setUp() throws Exception {
    v1 = new Vehicle("1234", "BMW", "X5",
        LocalDate.of(2020, 2, 1), 2000f);
    v2 = new Vehicle("222", "BMW", "X5",
        LocalDate.of(2021, 1, 1), 0f);
    v3 = new Vehicle("556", "Benz", "GLC300",
        LocalDate.of(2020, 1, 5), 10000f);
    v4 = new Vehicle("567", "BMW", "X3",
        LocalDate.of(2015, 5, 1), 50000f);
    v5 = new Vehicle("706", "Honda", "X5",
        LocalDate.of(2022, 1, 1), 0f);
    vehicleList1 = new ArrayList<>();
    vehicleList1.add(v1);
    vehicleList1.add(v2);
    vehicleList1.add(v3);
    vehicleList1.add(v4);
    vehicleList1.add(v5);
    vehicleList2 = new ArrayList<>();
    vehicleList2.add(v1);
    vehicleList2.add(v5);
    operator1 = new VehicleOperator("A", "xxx",
        LocalDate.of(1985, 6, 6), vehicleList1);
    operator2 = new VehicleOperator("b", "scg",
        LocalDate.of(1990, 5, 1), vehicleList2);
    operatorList = new ArrayList<>();
    operatorList.add(operator1);
    operatorList.add(operator2);

    List<Vehicle> vehicleList3 = new ArrayList<>();
    vehicleList3.add(v4);
    operator3 = new VehicleOperator("HH", "xx",
        LocalDate.of(2000, 5, 6), vehicleList3);

    processor1 = new VehicleOperatorProcessor(operatorList);
  }

  @Test
  public void mysteryMethod() {
    List<Vehicle> expected = new ArrayList<>();
    expected.add(v1);
    expected.add(v2);
    assertEquals(expected, processor1.mysteryMethod(operator1, "BMW", "X5"));
  }

  @Test
  public void filterByManufacturingYear() {
    LocalDate makeYear = LocalDate.of(2020, 1, 1);
    operatorList.add(operator3);
    List<String> expected = new ArrayList<>();
    expected.add("A");
    expected.add("b");
    assertEquals(expected, processor1.filterByManufacturingYear(makeYear));
  }
}