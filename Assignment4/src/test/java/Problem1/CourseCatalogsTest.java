package Problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CourseCatalogsTest {
  Course course1;
  Course course2;
  Course course3;
  ICourseCatalogs empty;
  ICourseCatalogs spring;

  @Before
  public void setUp() throws Exception {
    course1 = new Course("A", "CS", 1);
    course2 = new Course("B", "MA", 2);
    course3 = new Course("C", "PY", 4);
    empty = CourseCatalogs.creatEmpty();
    spring = CourseCatalogs.creatEmpty();
    spring.append(course1);
    spring.append(course2);
    assertTrue(spring.count() == 2);
  }

  @Test
  public void creatEmpty() {
    CourseCatalogs newEmpty = CourseCatalogs.creatEmpty();
    assertTrue(empty.equals(newEmpty));
  }

  @Test
  public void append() {
    empty.append(course1);
    empty.append(course2);
    assertTrue(empty.equals(spring));
  }

  @Test
  public void remove() throws Exception {
    spring.remove(course2);
    empty.append(course1);
    assertTrue(empty.equals(spring));
    spring.append(course2);
    spring.append(course3);
    CourseCatalogs summer = new CourseCatalogs();
    spring.remove(course2);
    summer.append(course1);
    summer.append(course3);
    assertTrue(summer.equals(spring));
  }

  @Test (expected = CourseNotFoundException.class)
  public void removeWrong() throws CourseNotFoundException{
    spring.remove(course3);
  }
  @Test
  public void contains() {
    assertTrue(spring.contains(course1));
    assertFalse(spring.contains(course3));
  }

  @Test
  public void indexOf() {
    assertEquals(0, spring.indexOf(course1));
    assertEquals(1, spring.indexOf(course2));
    assertEquals(-1, spring.indexOf(course3));
  }

  @Test
  public void count() {
    assertEquals(2, spring.count());
  }

  @Test
  public void get() throws InvalidIndexException {
    assertTrue(course1.equals(spring.get(0)));
  }

  @Test (expected = InvalidIndexException.class)
  public void getWrong() throws InvalidIndexException {
    spring.get(4);
  }

  @Test
  public void isEmpty() {
    assertTrue(empty.isEmpty());
    assertFalse(spring.isEmpty());
  }

  @Test
  public void testToString() {
    String result = "CourseCatalogs{courseCatalogs=[CS1: A, MA2: B], size=2}";
    assertEquals(result, spring.toString());
    String result1 = "CourseCatalogs{courseCatalogs=[null], size=0}";
    assertEquals(result1, empty.toString());
  }

  @Test
  public void testEquals() throws Exception{
    assertEquals(spring, spring);
    assertNotEquals(null, spring);
    assertTrue(empty.equals(empty));
    assertFalse(empty.equals(spring));
    assertFalse(empty.equals(null));
    assertFalse(empty.equals(""));

    CourseCatalogs reverse = new CourseCatalogs();
    reverse.append(course2);
    reverse.append(course1);
    assertFalse(spring.equals(reverse));

    CourseCatalogs fall = new CourseCatalogs();
    Course course4 = new Course("Computer", "CS", 1);
    fall.append(course4);
    empty.append(course1);
    assertNotEquals(fall, empty);
    Course course5 = new Course("Computer", "X", 1);
    empty.remove(course1);
    empty.append(course5);
    assertNotEquals(empty, fall);
    Course course6 = new Course("Computer", "CS", 5);
    empty.remove(course5);
    empty.append(course6);
    assertNotEquals(empty, fall);
  }

  @Test
  public void testHashCode() {
    assertTrue(empty.hashCode() == CourseCatalogs.creatEmpty().hashCode());
    empty.append(course1);
    empty.append(course2);
    assertTrue(spring.hashCode() == empty.hashCode());
    empty.append(course3);
    assertFalse(spring.hashCode() == empty.hashCode());
  }
}