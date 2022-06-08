package Problem1;

/**
 * A List represents an CourseCatalog, mutable collection of Course.
 */
public interface ICourseCatalogs {

  /**
   * Add a Course to the end of the CourseCatalog.
   * @param course - a course from Course class.
   */
  void append(Course course);

  /**
   * Removes a specified Course from the CourseCatalog.
   * @param course - the course needs to be removed.
   * @throws CourseNotFoundException if the course not in the CourseCatalog.
   */
  void remove(Course course) throws CourseNotFoundException;

  /**
   * Checks if the specified course exists in the CourseCatalog.
   * @param course - the course need to be checked.
   * @return true if the CourseCatalog contains the course, false otherwise.
   */
  boolean contains(Course course);

  /**
   * Find the index of the specified Course in the CourseCatalog.
   * @param course - the course needs to check index.
   * @return the index of the specified Course in the CourseCatalog.
   */
  int indexOf(Course course);

  /**
   * Gets the number of Courses in the CourseCatalog.
   * @return the number of Courses in the CourseCatalog.
   */
  int count();

  /**
   * Returns the Course at the given index in the CourseCatalog.
   * @param index - index of the Course.
   * @return the Course at the given index in the CourseCatalog.
   * @throws InvalidIndexException if the index does not exist.
   */
  Course get(int index) throws InvalidIndexException;

  /**
   * Checks if the CourseCatalog is empty.
   * @return true if the CourseCatalog is empty, false otherwise.
   */
  boolean isEmpty();
}
