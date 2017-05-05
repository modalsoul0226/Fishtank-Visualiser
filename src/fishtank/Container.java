package fishtank;

import java.util.ArrayList;

/**
 * A utility class for FishTank. A container contains all the items in FishTank.
 */
public class Container {
  /** The container for Fish objects. */
  private static ArrayList<Fish> fish = new ArrayList<Fish>();
  /** The container for HungryFish objects. */
  private static ArrayList<HungryFish> hungryFish = new ArrayList<HungryFish>();
  /** The container for Bubble objects. */
  private static ArrayList<Bubble> bubbles = new ArrayList<Bubble>();
  /** The container for Seaweed objects. */
  private static ArrayList<Seaweed> seaWeeds = new ArrayList<Seaweed>();
  /** The container for KillerFish objects. */
  private static ArrayList<FishKiller> fishKiller = new ArrayList<FishKiller>();

  /**
   * Initialize a new fish at the specified cursor location.
   * 
   * @param xcoord the x coordinate of the fish's cursor location.
   * @param ycoord the y coordinate of the fish's cursor location.
   */
  public static void setFish(int xcoord, int ycoord) {
    fish.add(new Fish(xcoord, ycoord));
  }

  /**
   * Get current fish in the FishTank.
   * 
   * @return an ArrayList containing fish.
   */
  public static ArrayList<Fish> getFish() {
    return fish;
  }

  /**
   * Get hungryFish in the FishTank.
   * 
   * @return an ArrayList containing fish.
   */
  public static ArrayList<HungryFish> getHungryFish() {
    return hungryFish;
  }

  /**
   * Initialize a new fish at the specified cursor location.
   * 
   * @param xcoord the x coordinate of the hungry fish's cursor location.
   * @param ycoord the y coordinate of the hungry fish's cursor location.
   */
  public static void setHungryFish(int xcoord, int ycoord) {
    hungryFish.add(new HungryFish(xcoord, ycoord));
  }

  /**
   * Get bubbles in the FishTank.
   * 
   * @return an ArrayList containing bubbles.
   */
  public static ArrayList<Bubble> getBubbles() {
    return bubbles;
  }

  /**
   * Initialize a new bubble at the specified cursor location.
   * 
   * @param xcoord the x coordinate of the bubble's cursor location.
   * @param ycoord the y coordinate of the bubble's cursor location.
   */
  public static void setBubbles(int xcoord, int ycoord) {
    bubbles.add(new Bubble(xcoord, ycoord));
  }

  /**
   * Get seaweeds in the FishTank.
   * 
   * @return an ArrayList containing seaweeds.
   */
  public static ArrayList<Seaweed> getSeaWeeds() {
    return seaWeeds;
  }

  /**
   * Initialize a new seaweed at the specified cursor location.
   * 
   * @param numWeed the number of segments this seaweed is tall.
   * @param xcoord the x coordinate of the seaweed's cursor location.
   * @param ycoord the y coordinate of the seaweed's cursor location.
   */
  public static void setSeaWeeds(int numWeed, int xcoord, int ycoord) {
    seaWeeds.add(new Seaweed(numWeed, xcoord, ycoord));
  }

  /**
   * Remove the specified fish from FishTank.
   * 
   * @param sacrifice the Fish need to be removed.
   */
  public static void killFish(Fish sacrifice) {
    fish.remove(sacrifice);
  }

  /**
   * Get killer fish in the FishTank.
   * 
   * @return an ArrayList containing killer fish.
   */
  public static ArrayList<FishKiller> getFishKiller() {
    return fishKiller;
  }

  /**
   * Initialize a new fish killer at the specified cursor location.
   * 
   * @param xcoord the x coordinate of the fish killer's cursor location.
   * @param ycoord the y coordinate of the fish killer's cursor location.
   */
  public static void setFishKiller(int xcoord, int ycoord) {
    fishKiller.add(new FishKiller(xcoord, ycoord));
  }

}
