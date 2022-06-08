package Problem1;

import java.time.LocalDate;

public abstract class AbstractEmployee implements IProductivity{
  protected String employeeID;
  protected ContactInfo contactInfo;
  protected LocalDate employmentDate;
  protected EducationLevel educationLevel;
  protected EmploymentLevel employmentLevel;
  protected Double lastYearEarning;
  protected static final Double NO_BONUS = 0.0;
  private static final Double EARNING_BOUND = 125000.0;
  private static final Double EMPLOYMENT_LEVEL_BONUS = 1.3;

  public AbstractEmployee(String employeeID, ContactInfo contactInfo, LocalDate employmentDate,
      EducationLevel educationLevel, EmploymentLevel employmentLevel, Double lastYearEarning) {
    this.employeeID = employeeID;
    this.contactInfo = contactInfo;
    this.employmentDate = employmentDate;
    this.educationLevel = educationLevel;
    this.employmentLevel = employmentLevel;
    this.lastYearEarning = lastYearEarning;
  }

  public Double estimateProductivity() {
    return this.baseProductivity() + this.employmentLevelBonus();
  }

  protected abstract Double baseProductivity();

  private Double employmentLevelBonus() {
    if (this.lastYearEarning > EARNING_BOUND &&
        this.employmentLevel.equals(EmploymentLevel.INTERMEDIATE_LEVEL)) {
      return EMPLOYMENT_LEVEL_BONUS;
    }
    return NO_BONUS;
  }
}
