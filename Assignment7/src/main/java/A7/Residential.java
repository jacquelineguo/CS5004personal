package A7;

public class Residential extends Property {

  protected Integer bedrooms;
  protected Double bathrooms;

  public Residential(String address, Integer size, Integer bedrooms, Double bathrooms) {
    super(address, size);

    this.bedrooms = bedrooms;
    this.bathrooms = bathrooms;

  }
}
