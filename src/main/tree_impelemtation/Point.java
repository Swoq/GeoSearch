package main.tree_impelemtation;

/**
 * Currently hardcoded to 2 dimensions, but could be extended.
 */
public class Point {
    /**
     * The (x, y) coordinates of the point.
     */
    public float x, y;

    /**
     * Constructor.
     *
     * @param x The x coordinate of the point
     * @param y The y coordinate of the point
     */
    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Copy from another point into this one
     */
    public void set(Point other) {
        x = other.x;
        y = other.y;
    }

    /**
     * Print as a string in format "(x, y)"
     */
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    /**
     * @return X coordinate rounded to an int
     */
    public int xInt() {
        return (int) Math.round(x);
    }

    /**
     * @return Y coordinate rounded to an int
     */
    public int yInt() {
        return (int) Math.round(y);
    }
}
