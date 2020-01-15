package Day3;

/**
 * Point representation class.
 */
public class Point {
    private int x;
    private int y;

    /**
     * Constructor of Point.
     *
     * @param x X coordinate.
     * @param y Y coordinate.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns x coordinate.
     *
     * @return Returns X coordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * Returns y coordinate.
     *
     * @return Returns Y coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * Returns String representation of Point (to tests).
     *
     * @return Returns String representation of Point.
     */
    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
