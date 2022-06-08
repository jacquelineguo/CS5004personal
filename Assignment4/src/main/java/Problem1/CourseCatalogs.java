package Problem1;

import java.util.Arrays;
import java.util.Objects;

/**
 * CourseCatalog class — an ordered, mutable collection, which will be used as part of a university
 * course registration system.
 */
public class CourseCatalogs implements ICourseCatalogs{
  private static final int NUM_SLOTS = 1;
  private static final int EMPTY = 0;
  private Course[] courseCatalogs;
  private int index;

  /**
   * Constructor for CourseCatalog class.
   */
  public CourseCatalogs() {
    this.courseCatalogs = new Course[NUM_SLOTS];
    this.index = 0;
  }

  /**
   * Creat an empty CourseCatalog.
   * @return an empty CourseCatalog.
   */
  public static CourseCatalogs creatEmpty() {
    return new CourseCatalogs();
 }

  /**
   * Add a Course to the end of the CourseCatalog.
   * @param course - a course from Course class.
   */
  @Override
  public void append(Course course) {
    if (!this.inSizeRange()) {
      this.resizeLarge();
      this.courseCatalogs[index - NUM_SLOTS] = course;
    }
    else {
      this.courseCatalogs[this.index] = course;
      this.index++;
    }
  }

  /**
   * Helper function that checks if there is room in the course catalogs array to add a new course
   * to the list.
   *
   * @return true if there is space available, false otherwise
   */
  private boolean inSizeRange() {
    return (this.index + NUM_SLOTS <= this.courseCatalogs.length);
  }

  /**
   * Increase the size of the course catalog array. This involves creating a temporary new array,
   * adding the existing data to the new array, then setting the data array to the new array.
   */
  private void resizeLarge() {
    int newSize = this.index + NUM_SLOTS;
    Course[] newCourse = new Course[newSize];
    this.copyItems(this.courseCatalogs, newCourse);
    this.courseCatalogs = newCourse;
    this.index = newSize;
  }

  /**
   * Decrease the size of the course catalog array. This involves creating a temporary new array,
   * adding the existing data to the new array except the one need to be removed, then setting the
   * data array to the new array.
   */
  private void resizeSmaller(int index) {
    Course[] newCourse = new Course[this.index - NUM_SLOTS];
    for (int i = 0; i < this.courseCatalogs.length; i++) {
      if (i < index) {
        newCourse[i] = this.courseCatalogs[i];
      }
      else if (i == index) {
        continue;
      }
      else {
        newCourse[i - NUM_SLOTS] = this.courseCatalogs[i];
      }
    }
    this.courseCatalogs = newCourse;
    this.index = this.index - NUM_SLOTS;
  }

  /**
   * Helper function used by add and insert methods. Copies the items from one array to another.
   * @param from The array to copy from.
   * @param to The array to copy to.
   * @param fromStart The index in the "from" array to start copying from.
   * @param fromEnd The index in the "from" array to end at (exclusive).
   * @param toStart The index in the "to" array to start copying to.
   */
  private void copyItems(Course[] from, Course[] to, int fromStart, int fromEnd, int toStart) {
    if (toStart >= 0) {
      for (int i = fromStart; i < fromEnd; i++) {
        to[toStart] = from[i];
        toStart++;
      }
    }
  }

  /**
   * Shortcut version of the helper method above. Will copy the entirety of the "from" array to the
   * "to" array.
   * @param from The array to copy from.
   * @param to The array to copy to.
   */
  private void copyItems(Course[] from, Course[] to) {
    this.copyItems(from, to, 0, from.length, 0);
  }

  /**
   * Removes a specified Course from the CourseCatalog.
   * @param course - the course needs to be removed.
   * @throws CourseNotFoundException if the course not in the CourseCatalog.
   */
  @Override
  public void remove(Course course) throws CourseNotFoundException{
    if (!this.contains(course)) {
      throw new CourseNotFoundException();
    }
    int index = indexOf(course);
    this.resizeSmaller(index);
  }

  /**
   * Checks if the specified course exists in the CourseCatalog.
   * @param course - the course need to be checked.
   * @return true if the CourseCatalog contains the course, false otherwise.
   */
  @Override
  public boolean contains(Course course) {
    int i;
    for (i = 0; i < this.courseCatalogs.length; i++) {
      if (course.equals(this.courseCatalogs[i])) {
        return true;
      }
    }
    return false;
  }

  /**
   * Find the index of the specified Course in the CourseCatalog.
   * @param course - the course needs to check index.
   * @return the index of the specified Course in the CourseCatalog.
   */
  @Override
  public int indexOf(Course course) {
    int i;
    for (i = 0; i < this.courseCatalogs.length; i++) {
      if (course.equals(courseCatalogs[i])) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Gets the number of Courses in the CourseCatalog.
   * @return the number of Courses in the CourseCatalog.
   */
  public int count() {
    return this.courseCatalogs.length;
  }

  /**
   * Helper method used by get and insert. Checks if the provided index is in bounds.
   * @param index The index to use.
   * @throws InvalidIndexException
   */
  private void checkBounds(int index) throws InvalidIndexException {
    if (index >= this.index || index < 0)
      throw new InvalidIndexException();
  }

  /**
   * Returns the Course at the given index in the CourseCatalog.
   * @param index - index of the Course.
   * @return the Course at the given index in the CourseCatalog.
   * @throws InvalidIndexException if the index does not exist.
   */
  public Course get(int index) throws InvalidIndexException{
    this.checkBounds(index);
    return this.courseCatalogs[index];
  }

  /**
   * Checks if the CourseCatalog is empty.
   * @return true if the CourseCatalog is empty, false otherwise.
   */
  public boolean isEmpty() {
    return this.index == EMPTY;
  }

  @Override
  public String toString() {
    return "CourseCatalogs{" +
        "courseCatalogs=" + Arrays.toString(courseCatalogs) +
        ", size=" + index +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CourseCatalogs)) {
      return false;
    }
    CourseCatalogs that = (CourseCatalogs) o;
    return index == that.index && Arrays.equals(courseCatalogs, that.courseCatalogs);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(index);
    result = 31 * result + Arrays.hashCode(courseCatalogs);
    return result;
  }
}
