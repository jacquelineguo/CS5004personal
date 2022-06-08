package problem1;

/**
 * Class Runner represents athlete who is a runner.
 */
public class Runner extends Athlete{
  private Double best5Ktime;
  private Double bestHalfMarathonTime;
  private String favoriteRunningEvent;

  /**
   * Main constructor for Runner
   *
   * @param athletesName runner's name
   * @param height runner's height
   * @param weight runner's weight
   * @param league runner's league
   * @param best5Ktime runner's best 5K time
   * @param bestHalfMarathonTime runner's best half-marathon time
   * @param favoriteRunningEvent runner's favorite running event.
   */
  public Runner(Name athletesName, Double height, Double weight, String league, Double best5Ktime,
      Double bestHalfMarathonTime, String favoriteRunningEvent) {
    super(athletesName, height, weight, league);
    this.best5Ktime = best5Ktime;
    this.bestHalfMarathonTime = bestHalfMarathonTime;
    this.favoriteRunningEvent = favoriteRunningEvent;
  }
  /**
   * constructor for Runner
   *
   * @param athletesName runner's name
   * @param height runner's height
   * @param weight runner's weight
   * @param best5Ktime runner's best 5K time
   * @param bestHalfMarathonTime runner's best half-marathon time
   * @param favoriteRunningEvent runner's favorite running event.
   */
  public Runner(Name athletesName, Double height, Double weight, Double best5Ktime, Double bestHalfMarathonTime,
      String favoriteRunningEvent) {
    super(athletesName, height, weight);
    this.best5Ktime = best5Ktime;
    this.bestHalfMarathonTime = bestHalfMarathonTime;
    this.favoriteRunningEvent = favoriteRunningEvent;
  }

  /**
   * @return runner's best 5K time
   */
  public Double getBest5Ktime() {
    return best5Ktime;
  }

  /**
   * @return runner's best half-marathon time
   */
  public Double getBestHalfMarathonTime() {
    return bestHalfMarathonTime;
  }

  /**
   * @return runner's favorite running event
   */
  public String getFavoriteRunningEvent() {
    return favoriteRunningEvent;
  }

}
