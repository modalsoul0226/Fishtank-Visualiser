package fishtank;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * A fish tank simulation.
 */
public class FishTank {

  /**
   * Start the fishies!
   * 
   * @param pars ignored. Why is this normally called args when the thing is called a parameter?
   * @throws InterruptedException Program interrupted.
   */
  public static void main(String[] pars) throws InterruptedException {

    // The window in which the fish swim.
    FishFrame frame = new FishFrame();
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent event) {
        System.exit(0);
      }
    });

    // Initialize items in the FishTank at specified locations.
    int[][] fishLocation = {{23, 18}, {6, 12}, {17, 4}, {15, 28}, {15, 36}, {16, 35}, {16, 35},
        {16, 18}, {23, 18}, {6, 12}};
    int[][] hunFishLocation = {{10, 33}};
    int[][] weedLocation = {{13, 25}, {24, 33}, {32, 25}};
    int[][] killerLocation = {{57, 27}};

    for (int[] each : fishLocation) {
      Container.setFish(each[0], each[1]);
    }

    for (int[] each : hunFishLocation) {
      Container.setHungryFish(each[0], each[1]);
    }

    for (int[] each : killerLocation) {
      Container.setFishKiller(each[0], each[1]);
    }

    for (int i = 5; i <= 7; i++) {
      Container.setSeaWeeds(i, weedLocation[i - 5][0], weedLocation[i - 5][1]);
    }

    // Show it all!
    frame.setSize(640, 480);
    frame.setLocation(10, 10);
    frame.setVisible(true);

    // Every .3 seconds, tell each item in the fish tank to take
    // a turn.
    while (true) {

      for (Fish each : Container.getFish()) {
        each.move();
      }

      for (HungryFish each : Container.getHungryFish()) {
        each.move();
      }

      for (FishKiller each : Container.getFishKiller()) {
        each.move();
        each.kill();
      }

      for (Seaweed each : Container.getSeaWeeds()) {
        each.wave();
      }

      for (Bubble each : Container.getBubbles()) {
        each.bubFloat();
      }
      // Tell the fish tank to redraw itself.
      frame.repaint();

      // Wait .3 seconds before redoing the queue.
      Thread.sleep(300);
    }

  }
}
