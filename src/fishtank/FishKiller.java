package fishtank;

public class FishKiller extends Fish {

  /**
   * Construct a new FishKiller.
   * 
   * @param xcoord the x coordinate of the fish killer's cursor location.
   * @param ycoord the y coordinate of the fish killer's cursor location.
   */
  public FishKiller(int xcoord, int ycoord) {
    super(xcoord, ycoord);
    appearance = "><KILLER>";
  }

  /**
   * One fish killer can only eat four fish. Kill nearby fish by removing them from FishTank.
   * Appearance will grow after killing a fish.
   */
  public void kill() {
    int[] curLocation = getLocation();
    Fish target = null;
    for (Fish each : Container.getFish()) {
      // Kill fish nearby if it has not eaten four fish.
      if ((each.getLocation()[0] <= (curLocation[0] + 1))
          && ((curLocation[0] - 1) <= each.getLocation()[0])) {
        target = each;
      }
    }
    if ((target instanceof Fish) && (appearance.length() <= 15)) {
      Container.killFish(target);
      grow();
    }
  }

  /**
   * Grow longer after killing a fish.
   */
  private void grow() {
    StringBuilder newShape = new StringBuilder(appearance);
    if (appearance.charAt(0) == '>') {
      newShape.insert(1, "<>");
    } else {
      newShape.insert(appearance.length() - 1, "<>");
    }
    appearance = newShape.toString();
  }
}
