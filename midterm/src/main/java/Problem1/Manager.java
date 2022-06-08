package Problem1;

import java.time.LocalDate;

public class Manager extends AbstractFullTime{
  private Integer managedEmployees;
  private static final Integer MANAGE_LOWER = 8;
  private static final Integer MANAGE_UPPER = 25;
  private static final Double MANAGE_BONUS = 1.7;

  public Manager(String employeeID, ContactInfo contactInfo, LocalDate employmentDate,
      EducationLevel educationLevel, EmploymentLevel employmentLevel, Double lastYearEarning,
      Double basePay, Double bonuses, Double overtimePay, LocalDate lastPromotionDate,
      Integer numOfProjects, Integer managedEmployees) {
    super(employeeID, contactInfo, employmentDate, educationLevel, employmentLevel, lastYearEarning,
        basePay, bonuses, overtimePay, lastPromotionDate, numOfProjects);

    this.managedEmployees = managedEmployees;
  }

  @Override
  public Double estimateProductivity() {
    return super.estimateProductivity() + this.managerBonus();
  }

  private Double managerBonus() {
    if (this.managedEmployees > MANAGE_LOWER && this.managedEmployees < MANAGE_UPPER) {
      return MANAGE_BONUS;
    }
    return NO_BONUS;
  }
}
