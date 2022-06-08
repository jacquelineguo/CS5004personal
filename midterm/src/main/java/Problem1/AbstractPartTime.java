package Problem1;

import java.time.LocalDate;

public abstract class AbstractPartTime extends AbstractEmployee{
  protected Double contractualWorkingHrs;
  protected Double actualWorkingHrs;
  protected Double bonusEarnings;
  private static final Double FACTOR = 5.0;

  public AbstractPartTime(String employeeID, ContactInfo contactInfo, LocalDate employmentDate,
      EducationLevel educationLevel, EmploymentLevel employmentLevel, Double lastYearEarning,
      Double contractualWorkingHrs, Double actualWorkingHrs, Double bonusEarnings) {
    super(employeeID, contactInfo, employmentDate, educationLevel,
        employmentLevel, lastYearEarning);

    this.contractualWorkingHrs = contractualWorkingHrs;
    this.actualWorkingHrs = actualWorkingHrs;
    this.bonusEarnings = bonusEarnings;
  }

  @Override
  protected Double baseProductivity() {
    return this.actualWorkingHrs / this.contractualWorkingHrs * FACTOR;
  }
}
