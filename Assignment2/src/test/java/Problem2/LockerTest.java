package Problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LockerTest {
  Locker locker1;
  Item item;
  Item newItem;
  Recipient msJ;

  @Before
  public void setUp() throws Exception {
    msJ = new Recipient("Alice", "Jackson", "ajackson@gmail.com");
    newItem = new Item(3, 3, 3, msJ);
    locker1 = new Locker(5, 6, 8, null, newItem, msJ);
  }

  @Test
  public void getMaxWidth() {
    assertEquals(5, locker1.getMaxWidth());
  }

  @Test
  public void getMaxHeight() {
    assertEquals(6, locker1.getMaxHeight());
  }

  @Test
  public void getMaxDepth() {
    assertEquals(8, locker1.getMaxDepth());
  }

  @Test
  public void getItem() {
    assertTrue(locker1.getItem() == null);
  }

  @Test
  public void getNewItem() {
    assertTrue(locker1.getNewItem().equals(newItem));
  }

  @Test (expected = InvalidSizeDimensionException.class)
  public void invalidWidth() throws InvalidSizeDimensionException{
    Locker locker11 = new Locker(0, 6, 8, null, newItem, msJ);
    Locker locker12 = new Locker(-5, 6, 8, null, newItem, msJ);
  }

  @Test (expected = InvalidSizeDimensionException.class)
  public void invalidHeight() throws InvalidSizeDimensionException{
    Locker locker13 = new Locker(5, 0, 8, null, newItem, msJ);
    Locker locker14 = new Locker(5, -6, 8, null, newItem, msJ);
  }

  @Test (expected = InvalidSizeDimensionException.class)
  public void invalidDepth() throws InvalidSizeDimensionException{
    Locker locker15 = new Locker(5, 6, 0, null, newItem, msJ);
    Locker locker16 = new Locker(5, 6, -8, null, newItem, msJ);
  }

  @Test
  public void addMail() throws InvalidLockerOccupiedException, InvalidLockerSizeException{
    locker1.addMail();
    assertTrue(newItem.equals(locker1.getItem()));
  }

  @Test (expected = InvalidLockerOccupiedException.class)
  public void lockerOccupied() throws Exception{
    Recipient msW = new Recipient("X", "Y", "Z");
    Item item1 = new Item(2, 2, 2, msW);
    Locker locker2 = new Locker(4, 5, 6, newItem, item1, msW);
    locker2.addMail();
  }

  @Test (expected = InvalidLockerSizeException.class)
  public void invalidLockerWidth() throws Exception{
    Locker locker3 = new Locker(2, 2, 2, null, newItem, msJ);
    locker3.addMail();
  }

  @Test (expected = InvalidLockerSizeException.class)
  public void invalidLockerHeight() throws Exception{
    Locker locker20 = new Locker(4, 2, 5, null, newItem, msJ);
    locker20.addMail();
  }

  @Test (expected = InvalidLockerSizeException.class)
  public void invalidLockerDepth() throws Exception{
    Locker locker21 = new Locker(4, 6, 1, null, newItem, msJ);
    locker21.addMail();
  }

  @Test
  public void pickupMail() throws Exception {
    Locker locker4 = new Locker(4, 5, 6, newItem, null, msJ);
    locker4.pickupMail(msJ);
    assertTrue(locker4.getItem() == null);
  }

  @Test (expected = InvalidPickupMailException.class)
  public void noItem() throws Exception{
    locker1.pickupMail(msJ);
  }

  @Test (expected = InvalidRecipientException.class)
  public void incorrectRecipient() throws Exception {
    Recipient msW = new Recipient("X", "Y", "Z");
    Locker locker5 = new Locker(4, 5, 6, newItem, null, msJ);
    locker5.pickupMail(msW);
  }
}