package Problem1;

import java.time.LocalDate;
import java.time.Period;

public abstract class AbstractFullTime extends AbstractEmployee{
  protected Double basePay;
  protected Double bonuses;
  protected Double overtimePay;
  protected LocalDate lastPromotionDate;
  protected Integer numOfProjects;
  private static final Integer LOWER_BOUND = 3;
  private static final Integer PROJECT_UPPER = 7;
  private static final Double PROJECT_BONUS = 1.2;
  private static final Double PROMOTION_PENALTY = 0.8;

  public AbstractFullTime(String employeeID, ContactInfo contactInfo, LocalDate employmentDate,
      EducationLevel educationLevel, EmploymentLevel employmentLevel, Double lastYearEarning,
      Double basePay, Double bonuses, Double overtimePay, LocalDate lastPromotionDate,
      Integer numOfProjects) {
    super(employeeID, contactInfo, employmentDate, educationLevel,
        employmentLevel, lastYearEarning);

    this.basePay = basePay;
    this.bonuses = bonuses;
    this.overtimePay = overtimePay;
    this.lastPromotionDate = lastPromotionDate;
    this.numOfProjects = numOfProjects;
  }

  @Override
  public Double estimateProductivity() {
    return super.estimateProductivity() + this.projectsBonus() - promotionPenalty();
  }

  @Override
  protected Double baseProductivity() {
    return this.lastYearEarning / this.basePay;
  }

  private Double projectsBonus() {
    if (this.numOfProjects > LOWER_BOUND && this.numOfProjects < PROJECT_UPPER) {
      return PROJECT_BONUS;
    }
    return NO_BONUS;
  }

  private Double promotionPenalty() {
    LocalDate today = LocalDate.now();
    if (Period.between(this.lastPromotionDate, today).getYears() > LOWER_BOUND) {
      return PROMOTION_PENALTY;
    }
    return NO_BONUS;
  }
}
