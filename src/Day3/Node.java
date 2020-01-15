package Day3;

/**
 * Point on the map which is connected by 2 wires.
 */
public class Node {
    Point position;
    int distance;

    /**
     * Constructor of Node
     *
     * @param position Coodrinates of Node.
     * @param distance Distance of Node (length of both wires).
     */
    public Node(Point position, int distance) {
        this.position = position;
        this.distance = distance;
    }

    /**
     * Returns position of Node.
     *
     * @return Returns position.
     */
    public Point getPosition() {
        return position;
    }

    /**
     * Returns distance of Node.
     *
     * @return Returns position.
     */
    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "Node{" +
                "position=" + position +
                ", distance=" + distance +
                '}';
    }
}
