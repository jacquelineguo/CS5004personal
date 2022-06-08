package Problem1;

import java.time.LocalDate;

public class Consultant extends AbstractEmployee{
  private Double consultingRate;
  private Integer expectHrs;
  private Integer actualHrs;
  private static final Double DIVISOR = 100.0;
  private static final Double RATE_BOUND = 500.0;
  private static final Double BUMP_RATE = 1.7;
  private static final Double NO_BUMP = 1.0;

  public Consultant(String employeeID, ContactInfo contactInfo, LocalDate employmentDate,
      EducationLevel educationLevel, EmploymentLevel employmentLevel, Double lastYearEarning,
      Double consultingRate, Integer expectHrs, Integer actualHrs) {
    super(employeeID, contactInfo, employmentDate, educationLevel,
        employmentLevel, lastYearEarning);

    this.consultingRate = consultingRate;
    this.expectHrs = expectHrs;
    this.actualHrs = actualHrs;
  }

  @Override
  public Double estimateProductivity() {
    return super.estimateProductivity() * this.consultingBump();
  }

  @Override
  protected Double baseProductivity() {
    return this.consultingRate * (this.actualHrs - this.expectHrs) / DIVISOR;
  }

  private Double consultingBump() {
    if (this.consultingRate > RATE_BOUND) {
      return BUMP_RATE;
    }
    return NO_BUMP;
  }
}
