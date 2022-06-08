package Problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CourseTest {
  Course course;

  @Before
  public void setUp() throws Exception {
    course = new Course("A", "CS", 1001);

  }

  @Test
  public void testToString() {
    String result = "CS1001: A";
    assertEquals(result, course.toString());
  }

  @Test
  public void testEquals() {
    assertEquals(course, course);
    assertNotEquals(null, course);
    assertNotEquals("A", course);

    Course course1 = new Course("A", "CS", 1001);
    assertEquals(course1, course);

    Course course2 = new Course("B", "MA", 1005);
    assertNotEquals(course1, course2);
  }

  @Test
  public void testHashCode() {
    Course course1 = new Course("A", "CS", 1001);
    Course course2 = new Course("B", "MA", 1005);

    assertNotEquals(course1.hashCode(), course2.hashCode());
    assertEquals(course1.hashCode(), course.hashCode());
  }
}