package Problem1;

import static org.junit.Assert.*;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class ManagerTest {
  Manager manager;
  Manager manager1;
  Manager manager2;
  Name name;
  ContactInfo contactInfo;
  LocalDate employmentDate;


  @Before
  public void setUp() throws Exception {
    name = new Name("Jessica", "", "H");
    employmentDate = LocalDate.of(2010, 11, 11);
    LocalDate promotionDate = LocalDate.of(2015, 5, 11);
    contactInfo = new ContactInfo(name, "66 AVE", "LA", "CA",
        "90045", "123", "jessicah@gmail.com", name);
    manager = new Manager("E1", contactInfo, employmentDate,
        EducationLevel.BACHELORS_DEGREE, EmploymentLevel.INTERMEDIATE_LEVEL, 210000.0,
        150000.0, 60000.0, 0.0, promotionDate, 10,
        11);

    LocalDate employmentDate1 = LocalDate.of(2015, 11, 11);
    LocalDate promotionDate1 = LocalDate.of(2019, 5, 11);
    manager1 = new Manager("E1", contactInfo, employmentDate1,
        EducationLevel.MASTERS_DEGREE, EmploymentLevel.INTERMEDIATE_LEVEL, 210000.0,
        150000.0, 60000.0, 5000.0, promotionDate1, 10,
        5);

    LocalDate employmentDate2 = LocalDate.of(2018, 11, 11);
    LocalDate promotionDate2 = LocalDate.of(2019, 1, 1);
    manager2 = new Manager("E1", contactInfo, employmentDate2,
        EducationLevel.BACHELORS_DEGREE, EmploymentLevel.ENTRY_LEVEL, 150000.0,
        100000.0, 50000.0, 5000.0, promotionDate2, 6,
        25);
  }

  @Test
  public void estimateProductivity() {
    assertEquals(3.6, manager.estimateProductivity(), 0.1);
    assertEquals(2.7, manager1.estimateProductivity(), 0.1);
    assertEquals(2.7, manager2.estimateProductivity(), 0.1);
  }
}