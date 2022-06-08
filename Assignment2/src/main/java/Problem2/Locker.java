package Problem2;

/**
 * The Locker class representing the locker for managing the packages. It contains the info about
 * the locker's width, height, depth, if it's empty, item to add, and recipient.
 */
public class Locker {
  private int maxWidth;
  private int maxHeight;
  private int maxDepth;
  private Item item = null;
  private Item newItem;
  private Recipient recipient;
  private Recipient pickupPerson;
  private static final int SIZELIMIT = 1;

  /**
   * Constructor for Locker class.
   * @param maxWidth - the locker's width.
   * @param maxHeight - the locker's height.
   * @param maxDepth - the locker's depth.
   * @param item - the original item in the locker, null if it's empty.
   * @param newItem - the item need to be added to the locker.
   * @param recipient - the recipient's name.
   * @throws InvalidSizeDimensionException if the locker's dimension is smaller than 1.
   */
  public Locker(int maxWidth, int maxHeight, int maxDepth, Item item, Item newItem,
      Recipient recipient) throws InvalidSizeDimensionException{
    if (this.isValidWidth(maxWidth)) {
      this.maxWidth = maxWidth;
    }
    else {
      throw new InvalidSizeDimensionException();
    }
    if (this.isValidHeight(maxHeight)) {
      this.maxHeight = maxHeight;
    }
    else {
      throw new InvalidSizeDimensionException();
    }
    if (this.isValidDepth(maxDepth)) {
      this.maxDepth = maxDepth;
    }
    else {
      throw new InvalidSizeDimensionException();
    }
    this.item = item;
    this.newItem = newItem;
    this.recipient = recipient;
  }

  /**
   * A helper method to check if the locker's width is smaller than 1.
   * @param maxWidth - the locker's width.
   * @return true if it's a valid width, false otherwise.
   */
  private boolean isValidWidth(int maxWidth) {
    return maxWidth >= SIZELIMIT;
  }

  /**
   * A helper method to check if the locker's height is smaller than 1.
   * @param maxHeight - the locker's height.
   * @return true if it's a valid height, false otherwise.
   */
  private boolean isValidHeight(int maxHeight) {
    return maxHeight >= SIZELIMIT;
  }

  /**
   * A helper method to check if the locker's depth is smaller than 1.
   * @param maxDepth - the locker's depth.
   * @return true if it's a valid depth, false otherwise.
   */
  private boolean isValidDepth(int maxDepth) {
    return maxDepth >= SIZELIMIT;
  }

  /**
   * Get the locker's width.
   * @return locker's width.
   */
  public int getMaxWidth() {
    return this.maxWidth;
  }

  /**
   * Get the locker's height.
   * @return locker's height.
   */
  public int getMaxHeight() {
    return this.maxHeight;
  }

  /**
   * Get the locker's depth.
   * @return locker's depth.
   */
  public int getMaxDepth() {
    return this.maxDepth;
  }

  /**
   * Get the item in the locker's.
   * @return the item in the locker.
   */
  public Item getItem() {
    return this.item;
  }

  /**
   * Get the item needed to be add into the locker's.
   * @return the item needed to be add into the locker's.
   */
  public Item getNewItem() {
    return this.newItem;
  }

  /**
   * A method will add the mail item to the locker.
   * @throws InvalidLockerOccupiedException if the locker is occupied.
   * @throws InvalidLockerSizeException if the locker's size is not smaller than the item size.
   */
  public void addMail() throws InvalidLockerOccupiedException, InvalidLockerSizeException {
    if (this.item != null) {
      throw new InvalidLockerOccupiedException();
    }
    else if (newItem.getWidth() > this.maxWidth || newItem.getHeight() > this.maxHeight ||
    newItem.getDepth() > this.maxDepth) {
      throw new InvalidLockerSizeException();
    }
    else {
      this.item = this.newItem;
    }
  }

  /**
   * This method will remove and return the mail item from the locker
   * @param pickupPerson - the recipient who wants to pickup the item.
   * @return the item from the locker.
   * @throws InvalidPickupMailException if the locker is empty.
   * @throws InvalidRecipientException if the recipient name does not match.
   */
  public Item pickupMail(Recipient pickupPerson) throws InvalidPickupMailException,
      InvalidRecipientException {
    if (this.item == null) {
      throw new InvalidPickupMailException();
    }
    if (!recipient.getName().equals(pickupPerson.getName())) {
      throw new InvalidRecipientException();
    }
    else {
      Item pickupItem = this.item;
      this.item = null;
      return pickupItem;
    }
  }
}
