package problem1;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class TrendingTopicsTest {
  List<String> list;
  TrendingTopics trendingTopics;


  @Before
  public void setUp() throws Exception {
    list = Arrays.asList("Seattle", "wildfires", "DEFCON26", "NEU", "NEU", "Seattle", "Seattle",
        "NEU", "DEFCON26", "wildfires");
    trendingTopics = new TrendingTopics(list);
  }

  @Test
  public void countTopics() {
    Map<String, Integer> result = new HashMap<>();
    result.put("Seattle", 3);
    result.put("wildfires", 2);
    result.put("DEFCON26", 2);
    result.put("NEU", 3);
    assertEquals(result, trendingTopics.countTopics());
  }
}