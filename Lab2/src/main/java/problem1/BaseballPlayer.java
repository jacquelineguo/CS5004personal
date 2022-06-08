package problem1;
/**
 * Class BaseballPlayer represents a baseball player.
 */
public class BaseballPlayer extends Athlete{
  private String team;
  private Double averageBatting;
  private Integer seasonHomeRuns;

  /**
   * Constructor for a BaseballPlayer
   *
   * @param athletesName athlete's name
   * @param height athlete's height
   * @param weight athlete's weight
   * @param league athlete's league
   * @param team athlete's team
   * @param averageBatting athlete's batting average
   * @param seasonHomeRuns number of home runs the athlete has in the season.
   */
  public BaseballPlayer(Name athletesName, Double height, Double weight, String league, String team,
      Double averageBatting, Integer seasonHomeRuns) {
    super(athletesName, height, weight, league);
    this.team = team;
    this.averageBatting = averageBatting;
    this.seasonHomeRuns = seasonHomeRuns;
  }

  /**
  * Constructor for a BaseballPlayer
   *
   * @param athletesName athlete's name
   * @param height athlete's height
   * @param weight athlete's weight
   * @param team athlete's team
   * @param averageBatting athlete's batting average
   * @param seasonHomeRuns number of home runs the athlete has in the season.
   */
  public BaseballPlayer(Name athletesName, Double height, Double weight, String team, Double averageBatting,
      Integer seasonHomeRuns) {
    super(athletesName, height, weight);
    this.team = team;
    this.averageBatting = averageBatting;
    this.seasonHomeRuns = seasonHomeRuns;
  }

  /**
   * @return team name
   */
  public String getTeam() {
    return team;
  }


  /**
   * @return athlete's batting average
   */
  public Double getAverageBatting() {
    return averageBatting;
  }

  /**
   * @return number of home runs in the season by the athlete
   */
  public Integer getSeasonHomeRuns() {
    return seasonHomeRuns;
  }


}
