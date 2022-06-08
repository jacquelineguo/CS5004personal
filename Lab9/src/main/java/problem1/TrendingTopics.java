package problem1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TrendingTopics class represents a counter of topics which count the topic's occurrence and save
 * the topics as the key of a HashMap, occurrence as the value.
 */
public class TrendingTopics {
  private List<String> list;
  private static final Integer INCREMENT = 1;

  /**
   * Constructor for TrendingTopics class.
   * @param list - list of String.
   */
  public TrendingTopics(List<String> list) {
    this.list = list;
  }

  /**
   * A counter of topics which count the topic's occurrence and save the topics as the key of a
   * HashMap, occurrence as the value.
   * @return the HashMap which use different topics as the key, and it's occurrence as the value.
   */
  public Map<String, Integer> countTopics() {
    Map<String, Integer> result = new HashMap<>();

    for (String topic: this.list) {
      if (result.containsKey(topic)) {
        result.put(topic, result.get(topic) + INCREMENT);
      }
      else {
        result.put(topic, INCREMENT);
      }
    }
    return result;
  }
}
