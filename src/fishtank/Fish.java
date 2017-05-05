package fishtank;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 * A fish.
 */
public class Fish {

  /** How this fish appears on the screen. */
  protected String appearance;

  /** Indicates whether this fish is moving right. */
  private boolean goingRight;

  /** This fish's first coordinate. */
  private int xcoord;
  /** This fish's second coordinate. */
  private int ycoord;
  /** The colour of this fish. */
  private Color colour;
  /** The font used to draw instances of this class. */
  private static final Font FONT = new Font("Monospaced", Font.PLAIN, 10);

  /**
   * Constructs a new fish.
   * 
   * @param xcoord the x coordinate of the fish's cursor location.
   * @param ycoord the y coordinate of the fish's cursor location.
   */
  public Fish(int xcoord, int ycoord) {
    colour = Color.cyan.darker().darker().darker();
    appearance = "><>";
    goingRight = true;
    this.xcoord = xcoord;
    this.ycoord = ycoord;
  }



  /**
   * Causes this fish to blow a bubble.
   */
  private void blowBubble() {
    Container.setBubbles(xcoord, ycoord);
  }



  /**
   * Build and initialize this fish's forward and backward appearances.
   */
  private void turnAround() {
    goingRight = !goingRight;
    // Reverse the appearance.
    String reverse = "";
    for (int i = appearance.length() - 1; i >= 0; i--) {
      switch (appearance.charAt(i)) {
        case '>':
          reverse += "<";
          break;
        case '<':
          reverse += ">";
          break;
        default:
          reverse += appearance.charAt(i);
      }
    }
    appearance = reverse;
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
   * Causes this item to take its turn in the fish-tank simulation.
   */
  public void move() {

    // Move one spot to the right or left.
    if (goingRight) {
      xcoord += 1;
    } else {
      xcoord -= 1;
    }

    // Figure out whether I blow a bubble.
    double blow = Math.random();
    if (blow < 0.1) {
      blowBubble();
    }

    // Figure out whether I turn around.
    double turn = Math.random();
    if (turn < 0.1) {
      turnAround();
    }

    // Figure out whether to move up or down, or neither.
    double upDown = Math.random();
    if (upDown < 0.1) {
      ycoord += 1;
    } else if (upDown < 0.2) {
      ycoord -= 1;
    }

    // Check whether the fish has been out of bound.
    if ((xcoord <= 0) || (xcoord >= 65)) {
      turnAround();
    } else if (ycoord >= 45) {
      ycoord -= 1;
    } else if (ycoord <= 0) {
      ycoord += 1;
    }
  }

  /**
   * Get the location of this fish.
   * 
   * @return an array of x, y coordinates.
   */
  public int[] getLocation() {
    int[] location = {xcoord, ycoord};
    return location;
  }
}
