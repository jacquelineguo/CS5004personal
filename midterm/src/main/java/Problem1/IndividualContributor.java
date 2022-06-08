package Problem1;

import java.time.LocalDate;

public class IndividualContributor extends AbstractFullTime{
  private Integer numOfParents;
  private Integer numOfPublications;
  private Integer numOfCollaborations;
  private static final Integer PUBLICATION_BOUND = 5;
  private static final Double CONTRIBUTOR_BONUS = 1.6;

  public IndividualContributor(String employeeID, ContactInfo contactInfo, LocalDate employmentDate,
      EducationLevel educationLevel, EmploymentLevel employmentLevel, Double lastYearEarning,
      Double basePay, Double bonuses, Double overtimePay, LocalDate lastPromotionDate,
      Integer numOfProjects, Integer numOfParents, Integer numOfPublications,
      Integer numOfCollaborations) {
    super(employeeID, contactInfo, employmentDate, educationLevel, employmentLevel, lastYearEarning,
        basePay, bonuses, overtimePay, lastPromotionDate, numOfProjects);

    this.numOfParents = numOfParents;
    this.numOfPublications = numOfPublications;
    this.numOfCollaborations = numOfCollaborations;
  }

  @Override
  public Double estimateProductivity() {
    return super.estimateProductivity() + this.contributorBonus();
  }

  private Double contributorBonus() {
    if (this.numOfPublications > PUBLICATION_BOUND) {
      return CONTRIBUTOR_BONUS;
    }
    return NO_BONUS;
  }
}
