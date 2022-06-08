package Problem1;

import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class PainterTest {
  Painter painter;
  String[] genres = {"A", "B"};
  String[] awards = {"C", "D"};
  String[] exhibits = {"A"};

  @Before
  public void setUp() throws Exception {
    painter = new Painter("Jackson", 80, genres, awards, exhibits);
  }

  @Test
  public void getExhibits() {
    String[] result = {"A"};
    assertTrue(Arrays.equals(result, painter.getExhibits()));
  }

  @Test
  public void testEquals() throws Exception {
    assertEquals(painter, painter);
    assertNotEquals(null, painter);
    assertNotEquals("Jackson", painter);

    Painter painter1 = new Painter("Jackson", 80, genres, awards, exhibits);
    assertEquals(painter, painter1);

    Painter painter2 = new Painter("J", 89, genres, awards, exhibits);
    assertNotEquals(painter1, painter2);
  }

  @Test
  public void testHashCode() throws Exception {
    Painter painter1 = new Painter("Jackson", 80, genres, awards, exhibits);
    Painter painter2 = new Painter("J", 89, genres, awards, exhibits);

    assertEquals(painter1.hashCode(), painter.hashCode());
    assertNotEquals(painter.hashCode(), painter2.hashCode());
  }

  @Test
  public void testToString() throws Exception{
    String result = "Painter: AbstractVisualArtist{AbstractArtist{" +
        "name='Jackson'" +
        ", age=80" +
        ", genres=" + Arrays.toString(genres) +
        ", awards=" + Arrays.toString(awards) +
        "}, exhibits=" + Arrays.toString(exhibits) +
        '}';
    assertEquals(result, painter.toString());

    Painter painter2 = new Painter("J", 89, genres, awards, exhibits);
    assertNotEquals(result, painter2.toString());
  }
}