package Day3;

public class Node {
    Point position;
    int distance;

    public Node(Point position, int distance) {
        this.position = position;
        this.distance = distance;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
