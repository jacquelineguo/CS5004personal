package Problem1;

import java.time.LocalDate;

public class HourlyEmployee extends AbstractPartTime{
  private Double hourlyEarnings;
  private static final Double RATE_BOUND = 15.0;
  private static final Double HOURLY_BONUS = 2.0;

  public HourlyEmployee(String employeeID, ContactInfo contactInfo,
      LocalDate employmentDate, EducationLevel educationLevel, EmploymentLevel employmentLevel,
      Double lastYearEarning, Double contractualWorkingHrs, Double actualWorkingHrs,
      Double bonusEarnings, Double hourlyEarnings) {
    super(employeeID, contactInfo, employmentDate, educationLevel, employmentLevel, lastYearEarning,
        contractualWorkingHrs, actualWorkingHrs, bonusEarnings);

    this.hourlyEarnings = hourlyEarnings;
  }

  @Override
  public Double estimateProductivity() {
    return super.estimateProductivity() + this.hourlyBonus();
  }

  private Double hourlyBonus() {
    if (this.hourlyEarnings < RATE_BOUND) {
      return HOURLY_BONUS;
    }
    return NO_BONUS;
  }
}
