package Problem1;

import static org.junit.Assert.*;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class IndividualContributorTest {
  IndividualContributor person;
  IndividualContributor person1;
  IndividualContributor person2;
  IndividualContributor person3;
  Name name;
  ContactInfo contactInfo;
  LocalDate employmentDate;
  LocalDate promotionDate;

  @Before
  public void setUp() throws Exception {
    name = new Name("Jessica", "", "H");
    contactInfo = new ContactInfo(name, "66 AVE", "LA", "CA", "90045",
        "123", "jessicah@gmail.com", name);
    employmentDate = LocalDate.of(2020, 11, 11);
    promotionDate = LocalDate.of(2021, 3, 1);
    person = new IndividualContributor("E1", contactInfo, employmentDate,
        EducationLevel.BACHELORS_DEGREE, EmploymentLevel.ENTRY_LEVEL, 80000.0,
        50000.0, 30000.0, 0.0, promotionDate, 5,
        2, 7, 0);

    person1 = new IndividualContributor("E1", contactInfo,
        LocalDate.of(2010, 11, 11),
        EducationLevel.MASTERS_DEGREE, EmploymentLevel.ENTRY_LEVEL, 80000.0,
        50000.0, 30000.0, 0.0,
        LocalDate.of(2015, 11, 11), 5,
        2, 7, 3);

    person2 = new IndividualContributor("E1", contactInfo,
        LocalDate.of(2010, 11, 11),
        EducationLevel.MASTERS_DEGREE, EmploymentLevel.INTERMEDIATE_LEVEL, 150000.0,
        100000.0, 50000.0, 0.0,
        LocalDate.of(2015, 11, 16), 5,
        2, 7, 3);

    person3 = new IndividualContributor("E1", contactInfo,
        LocalDate.of(2010, 11, 11),
        EducationLevel.MASTERS_DEGREE, EmploymentLevel.INTERMEDIATE_LEVEL, 150000.0,
        100000.0, 50000.0, 5000.0,
        LocalDate.of(2015, 11, 16), 15,
        2, 3, 3);
  }

  @Test
  public void estimateProductivity() {
    assertEquals(4.4, person.estimateProductivity(), 0.1);
    assertEquals(3.6, person1.estimateProductivity(), 0.1);
    assertEquals(4.8, person2.estimateProductivity(), 0.1);
    assertEquals(2.0, person3.estimateProductivity(), 0.1);
  }
}