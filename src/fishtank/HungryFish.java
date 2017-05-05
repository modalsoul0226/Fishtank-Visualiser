package fishtank;

/**
 * A hungry fish.
 */
public class HungryFish extends Fish {

  /**
   * Constructs a new hungry fish.
   * 
   * @param xcoord the x coordinate of the hungry fish's cursor location.
   * @param ycoord the y coordinate of the hungry fish's cursor location.
   */
  public HungryFish(int xcoord, int ycoord) {
    super(xcoord, ycoord);
    appearance = "><MEHUNGRY>";
  }
}
