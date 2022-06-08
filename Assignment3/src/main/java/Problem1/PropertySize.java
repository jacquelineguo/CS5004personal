package Problem1;

/**
 * Enum for classifying property sizes.
 */
public enum PropertySize {
  SMALL{
    @Override
    public String toString() {return "Small";}
  },
  MEDIUM{
    @Override
    public String toString() {return "Medium";}
  },
  LARGE{
    @Override
    public String toString() {return "Large";}
  },
  EMPTY{
    @Override
    public String toString() {return "Empty";}
  },
}
