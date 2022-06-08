package Problem2;

/**
 * The Item class representing a mail item with the item's width, height, depth, and recipient info.
 */
public class Item {
  private int width;
  private int height;
  private int depth;
  private Recipient recipient;
  private static final int SIZELIMIT = 1;

  /**
   * Constructor for Item class.
   * @param width - the width of the mail item.
   * @param height - the height of the mail item.
   * @param depth - the depth of the mail item.
   * @param recipient - the item's recipient.
   * @throws InvalidSizeDimensionException if the width, height, and depth of the item is invalid.
   */
  public Item(int width, int height, int depth, Recipient recipient)
      throws InvalidSizeDimensionException {
    if (this.isValidWidth(width)) {
      this.width = width;
    }
    else {
      throw new InvalidSizeDimensionException();
    }
    if (this.isValidHeight(height)) {
      this.height = height;
    }
    else {
      throw new InvalidSizeDimensionException();
    }
    if (this.isValidDepth(depth)) {
      this.depth = depth;
    }
    else {
      throw new InvalidSizeDimensionException();
    }
    this.recipient = recipient;
  }

  /**
   * Helper method to validate the item's width.
   * @param width - the width of the mail item.
   * @return true if the width is valid, false otherwise.
   */
  private boolean isValidWidth(int width) {
    return width >= SIZELIMIT;
  }

  /**
   * Helper method to validate the item's height.
   * @param height - the height of the mail item.
   * @return true if the height is valid, false otherwise.
   */
  private boolean isValidHeight(int height) {
    return height >= SIZELIMIT;
  }

  /**
   * Helper method to validate the item's depth.
   * @param depth - the width of the mail item.
   * @return true if the depth is valid, false otherwise.
   */
  private boolean isValidDepth(int depth) {
    return depth >= SIZELIMIT;
  }

  /**
   * Get the width of the item.
   * @return width of the item.
   */
  public int getWidth() {
    return this.width;
  }

  /**
   * Get the height of the item.
   * @return height of the item.
   */
  public int getHeight() {
    return this.height;
  }

  /**
   * Get the depth of the item.
   * @return depth of the item.
   */
  public int getDepth() {
    return this.depth;
  }

  /**
   * Get the recipient of the item.
   * @return recipient of the item.
   */
  public Recipient getRecipient() {
    return this.recipient;
  }
}
