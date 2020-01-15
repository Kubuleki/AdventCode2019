package Day3;

import java.util.ArrayList;
import java.util.List;

/**
 * Comparator class.
 */
public class Comparator {
    /**
     * Method returns list of Nodes, where 2 wires are connected at the same time.
     *
     * @param wire1 First path.
     * @param wire2 Second path.
     * @return Returns list of Nodes, where 2 wires are connected.
     */
    public static List<Node> getNodes(Wire wire1, Wire wire2) {
        List<Node> nodes = new ArrayList<>();
        int distance1 = 0;
        int distance2 = 0;
        for (int i = 0; i < wire1.getLines().size(); i++) {
            for (int j = 0; j < wire2.getLines().size(); j++) {
                Point point = getPoint(wire1.getLines().get(i).getItselfStraigth(), wire2.getLines().get(j).getItselfStraigth());
                if (point != null) {
                    nodes.add(new Node(point, distance1 + distance2 + getDistance(point, wire2.getLines().get(j).getStartPoint()) + getDistance(point, wire1.getLines().get(i).getStartPoint())));
                }
                distance2 += getDistance(wire2.getLines().get(j).getStartPoint(), wire2.getLines().get(j).getEndPoint());
            }
            distance1 += getDistance(wire1.getLines().get(i).getStartPoint(), wire1.getLines().get(i).getEndPoint());
        }
        return nodes;
    }

    /**
     * Method returns point where lines are crossed.
     *
     * @param line1 First line.
     * @param line2 Second line.
     * @return Returns point where lines are crossed or null if not.
     */
    public static Point getPoint(Line line1, Line line2) {
        if (line1.isHorizontal() == line2.isHorizontal()) {
            return null;
        } else {
            if (line1.isHorizontal()) {
                if (line1.getStartPoint().getY() >= line2.getStartPoint().getY() && line1.getStartPoint().getY() <= line2.getEndPoint().getY() && line1.getStartPoint().getX() <= line2.getStartPoint().getX() && line1.getEndPoint().getX() >= line2.getStartPoint().getX()) {
                    return new Point(line2.getStartPoint().getX(), line1.getStartPoint().getY());
                } else return null;
            } else {
                if (line2.getStartPoint().getY() >= line1.getStartPoint().getY() && line2.getStartPoint().getY() <= line1.getEndPoint().getY() && line2.getStartPoint().getX() <= line1.getStartPoint().getX() && line2.getEndPoint().getX() >= line1.getStartPoint().getX()) {
                    return new Point(line1.getStartPoint().getX(), line2.getStartPoint().getY());
                } else return null;
            }
        }
    }

    /**
     * Returns answer for first part of the task.
     *
     * @param nodes List of Nodes.
     */
    public static void getAnswer(List<Node> nodes) {
        Point point = nodes.get(0).getPosition();
        for (Node n : nodes) {
            if (getDistance(n.getPosition()) < getDistance(point) && getDistance(n.getPosition()) != 0) {
                point = n.getPosition();
            }
        }
        System.out.println("The closest Node via position is: ");
        System.out.println(point + ", distance: " + Comparator.getDistance(point) + ".\n");
    }

    /**
     * Returns answer for second part of the task.
     *
     * @param nodes List of Nodes.
     */
    public static void getSecondAnswer(List<Node> nodes) {
        Node node = nodes.get(0);
        for (Node n : nodes) {
            if (n.getDistance() < node.getDistance()) {
                node = n;
            }
        }
        System.out.println("The closest Node via Wire length is: ");
        System.out.println(node.getPosition() + ", distance: " + node.getDistance());
    }

    /**
     * Method returns distance between center [0,0] and point.
     *
     * @param point Point, which distance is calculate.
     * @return Returns distance between center [0,0] and point.
     */
    public static int getDistance(Point point) {
        return Math.abs(point.getY()) + Math.abs(point.getX());
        // Also works diffrent solution, more elegant, but with more calculations:
        // return getDistance(new Point(0,0), point);
    }

    /**
     * Method returns distance between 2 points.
     *
     * @param firstPoint  First point.
     * @param secondPoint Second point.
     * @return Returns distance between 2 points.
     */
    public static int getDistance(Point firstPoint, Point secondPoint) {
        return Math.abs(firstPoint.getX() - secondPoint.getX()) + Math.abs(firstPoint.getY() - secondPoint.getY());
    }
}
