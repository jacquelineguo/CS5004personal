package finalExam.p1;

import java.time.LocalDate;

public class Vehicle {

  private String vehicleID;
  private String make;
  private String model;
  private LocalDate yearManufactured;
  private Float millage;

  public Vehicle(String vehicleID, String make, String model,
      LocalDate yearManufactured, Float millage) {
    this.vehicleID = vehicleID;
    this.make = make;
    this.model = model;
    this.yearManufactured = yearManufactured;
    this.millage = millage;
  }

  public String getVehicleID() {
    return vehicleID;
  }

  public String getMake() {
    return make;
  }

  public String getModel() {
    return model;
  }

  public LocalDate getYearManufactured() {
    return yearManufactured;
  }

  public Float getMillage() {
    return millage;
  }
}
