package fishtank;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 * Seaweed.
 */
public class Seaweed {
  /** The font used to draw instances of this class. */
  private static final Font FONT = new Font("Monospaced", Font.PLAIN, 10);


  /** The number of weed segments. */
  private int numWeed;

  /** Indicates whether the bottom segment is leaning right. */
  private boolean leanRight;

  /** My colour. Ah,the vagaries of British vs. US spelling. */
  private Color colour;

  /** This bubble's first coordinate. */
  private int xcoord;
  /** This bubble's second coordinate. */
  private int ycoord;


  /**
   * Constructs a new seaweed item at the specified cursor location (x,y),l segments tall.
   *
   * @param numWeed the number of segments this seaweed is tall.
   * @param xcoord the x coordinate of the bubble's cursor location.
   * @param ycoord the y coordinate of the bubble's cursor location.
   */
  public Seaweed(int numWeed, int xcoord, int ycoord) {
    this.numWeed = numWeed;
    colour = Color.green.darker().darker();
    this.xcoord = xcoord;
    this.ycoord = ycoord;
  }



  /**
   * Draws this fish tank item. Looks lovely waving in the current, doesn't it?
   *
   * @param graphics the graphics context in which to draw this item.
   */
  public void draw(Graphics graphics) {

    for (int i = 0; i < numWeed; i++) {
      if (i % 2 == 0) {
        if (leanRight) {
          // Draw a "/" seaweed segment for even number
          drawString(graphics, "/", xcoord, (-i + ycoord));
        } else {
          // Draw a "\" seaweed segment for even number
          drawString(graphics, "\\", xcoord, (-i + ycoord));
        }
      } else if (leanRight) {
        // Draw a "\" seaweed segment for odd number
        drawString(graphics, "\\", xcoord, (-i + ycoord));
      }
    }
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
    g.drawString(s, x * fm.charWidth('W'), y * fm.getAscent());
  }


  /**
   * Causes this item to take its turn in the fish-tank simulation.
   */
  public void wave() {
    leanRight = !leanRight;
  }
}
