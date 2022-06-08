package Problem1;

import java.time.LocalDate;

public class BenefitsEligibleEmployee extends AbstractPartTime{

  public BenefitsEligibleEmployee(String employeeID, ContactInfo contactInfo,
      LocalDate employmentDate, EducationLevel educationLevel, EmploymentLevel employmentLevel,
      Double lastYearEarning, Double contractualWorkingHrs, Double actualWorkingHrs,
      Double bonusEarnings) {
    super(employeeID, contactInfo, employmentDate, educationLevel, employmentLevel, lastYearEarning,
        contractualWorkingHrs, actualWorkingHrs, bonusEarnings);
  }

  @Override
  public Double estimateProductivity() {
    return super.estimateProductivity();
  }
}
