package Problem2;

public class EmptyCatalogException extends Exception{
  public EmptyCatalogException() {
    super("The catalog is empty, nothing to be remove.");
  }

}
