package Problem1;

import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class ActorTest {
  Actor actor;
  String[] genres = {"A", "B"};
  String[] awards = {"C", "D"};
  String[] movies = {"A"};
  String[] series = {"D"};
  String[] multimedia = {"F"};

  @Before
  public void setUp() throws Exception {
    actor = new
        Actor("Jennifer Lawrence", 30, genres, awards, movies, series, multimedia);
  }

  @Test
  public void getMovies() {
    String[] result = {"A"};
    assertTrue(Arrays.equals(result, actor.getMovies()));
  }

  @Test
  public void getSeries() {
    String[] result = {"D"};
    assertTrue(Arrays.equals(result, actor.getSeries()));
  }

  @Test
  public void getMultimedia() {
    String[] result = {"F"};
    assertTrue(Arrays.equals(result, actor.getMultimedia()));
  }

  @Test
  public void testEquals() throws Exception{
    assertEquals(actor, actor);
    assertNotEquals(null, actor);
    assertNotEquals("actor", actor);

    Actor actor1 = new Actor
        ("Jennifer Lawrence", 30, genres, awards, movies, series, multimedia);
    assertEquals(actor, actor1);

    Actor actor2 = new Actor
        ("Jennifer Lawrence", 35, genres, awards, movies, series, multimedia);
    assertNotEquals(actor, actor2);
  }

  @Test
  public void testHashCode() throws Exception{
    Actor actor1 = new Actor
        ("Jennifer Lawrence", 30, genres, awards, movies, series, multimedia);
    Actor actor2 = new Actor
        ("Jennifer Lawrence", 35, genres, awards, movies, series, multimedia);
    assertEquals(actor.hashCode(), actor1.hashCode());
    assertNotEquals(actor.hashCode(), actor2.hashCode());
  }

  @Test
  public void testToString() throws Exception{
    String result = "Actor: AbstractFilmArtist{AbstractArtist{" +
        "name='Jennifer Lawrence'" +
        ", age=30" +
        ", genres=" + Arrays.toString(genres) +
        ", awards=" + Arrays.toString(awards) +
        "}, movies=" + Arrays.toString(movies) +
        ", series=" + Arrays.toString(series) +
        ", multimedia=" + Arrays.toString(multimedia) +
        '}';
    assertEquals(result, actor.toString());

    Actor actor2 = new Actor
        ("Jennifer Lawrence", 35, genres, awards, movies, series, multimedia);
    assertNotEquals(result, actor2.toString());
  }

  @Test
  public void receiveAward() {
    actor.receiveAward("Y");
    String[] result = {"C", "D", "Y"};
    assertTrue(Arrays.equals(result, actor.getAwards()));
  }

  @Test
  public void getName() {
    assertEquals("Jennifer Lawrence", actor.getName());
  }

  @Test
  public void getAge() {
    Integer result = 30;
    assertEquals(result, actor.getAge());
  }

  @Test
  public void getGenres() {
    String[] result = {"A", "B"};
    assertTrue(Arrays.equals(result, actor.getGenres()));
  }

  @Test
  public void getAwards() {
    String[] result = {"C", "D"};
    assertTrue(Arrays.equals(result, actor.getAwards()));
  }

  @Test (expected = InvalidAgeException.class)
  public void invalidAge() throws InvalidAgeException {
    Actor actor1 = new Actor
        ("Jennifer Lawrence", -5, genres, awards, movies, series, multimedia);
    assertEquals(actor, actor1);

    Actor actor2 = new Actor
        ("Jennifer Lawrence", 130, genres, awards, movies, series, multimedia);
    assertEquals(actor, actor1);
  }
}