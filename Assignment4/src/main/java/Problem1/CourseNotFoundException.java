package Problem1;

public class CourseNotFoundException extends Exception{

  public CourseNotFoundException() {
    super("Cannot found the course in Course Catalogs.");
  }

}
