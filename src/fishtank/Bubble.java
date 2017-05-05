package fishtank;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 * A bubble.
 */
public class Bubble {

  /** How this bubble appears on the screen. */
  private String appearance;

  /** The font used to draw instances of this class. */
  private static final Font FONT = new Font("Monospaced", Font.PLAIN, 10);

  /** My colour. Ah, the vagaries of British vs. US spelling. */
  private Color colour;

  /** This bubble's first coordinate. */
  private int xcoord;
  /** This bubble's second coordinate. */
  private int ycoord;

  /**
   * Constructs a new bubble at the specified cursor location (x, y).
   *
   * @param xcoord the x coordinate of the bubble's cursor location.
   * @param ycoord the y coordinate of the bubble's cursor location.
   */
  public Bubble(int xcoord, int ycoord) {
    // Get a nice-looking grey for the bubble
    colour = Color.gray.darker().darker().darker();
    // start off with . as the appearance
    appearance = ".";
    // set the x, y coordinates.
    this.xcoord = xcoord;
    this.ycoord = ycoord;
  }



  /**
   * Draws the given string in the given graphics context at at the given cursor location.
   *
   * @param g the graphics context in which to draw the string.
   * @param s the string to draw.
   * @param x the x-coordinate of the string's cursor location.
   * @param y the y-coordinate of the string's cursor location.
   */
  private void drawString(Graphics g, String s, int x, int y) {
    g.setColor(colour);
    g.setFont(FONT);
    FontMetrics fm = g.getFontMetrics(FONT);
    g.drawString(s, y * fm.charWidth('W'), x * fm.getAscent());
  }


  /**
   * Draws this fish tank item.
   *
   * @param graphics the graphics context in which to draw this item.
   */
  public void draw(Graphics graphics) {
    drawString(graphics, appearance, ycoord, xcoord);
  }


  /**
   * Figure out whether the appearance of the bubble should grow or not.
   */
  private void growOrNot() {
    // Figure out whether to grow, if at all.
    double randomMove = Math.random();
    // Occasionally change a . to a o or a o to a O
    if (randomMove < 0.05) {
      // If the appearance is a ., change it to an o
      if (appearance.equals(".")) {
        appearance = "o";
        // If the appearance is an o, change it to a O
      } else if (appearance.equals("o")) {
        appearance = "O";
      }
    }
  }

  /**
   * Make this bubble float.
   */
  public void bubFloat() {
    double randomMove = Math.random();
    if (randomMove < 0.33) {
      floatStraightUp();
    } else if (randomMove < 0.66) {
      floatRightUp();
    } else {
      /* heybub.d >= 0.66 */ floatLeftUp();
    }
  }

  /**
   * Causes this item to take its turn in the fish-tank simulation, moving straight up.
   */
  private void floatStraightUp() {

    // Move upwards, and do not move left or right.
    ycoord--;

    growOrNot();
  }

  /**
   * Causes this item to take its turn in the fish-tank simulation, moving up and left.
   */
  private void floatLeftUp() {

    // Move upwards.
    ycoord--;
    xcoord -= 1; // left

    growOrNot();
  }

  /**
   * Causes this item to take its turn in the fish-tank simulation.
   */
  private void floatRightUp() {

    // Move upwards.
    ycoord--;
    xcoord += 1;// right

    growOrNot();
  }
}
