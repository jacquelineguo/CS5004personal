package finalExam.p2;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class TravelerIterator implements Iterator<Traveler> {
  private List<Traveler> travelers;
  private int currentIndex;
  private static final Integer TRAVELED_TIMES = 5;

  public TravelerIterator(List<Traveler> travelers) {
    this.travelers = travelers;
  }

  /**
   * Returns {@code true} if the iteration has more elements. (In other words, returns {@code true}
   * if {@link #next} would return an element rather than throwing an exception.)
   *
   * @return {@code true} if the iteration has more elements
   */
  @Override
  public boolean hasNext() {
    while(this.currentIndex < this.travelers.size()) {
      if (this.traveledMoreThanFiveTimes(this.travelers.get(this.currentIndex)))
        return true;
      else
        this.currentIndex++;
    }
    return false;
  }

  /**
   * Returns the next element in the iteration.
   *
   * @return the next element in the iteration
   * @throws NoSuchElementException if the iteration has no more elements
   */
  @Override
  public Traveler next() {
    Traveler next = this.travelers.get(this.currentIndex);
    this.currentIndex++;
    return next;
  }


  private boolean traveledMoreThanFiveTimes(Traveler traveler) {
    return traveler.traveledDestinations().size() > TRAVELED_TIMES;
  }
}
