package Day3;

import java.util.ArrayList;
import java.util.List;

public class Comparator {
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

    public static int getDistance(Point point) {
        return Math.abs(point.getY()) + Math.abs(point.getX());
    }

    public static int getDistance(Point startPoint, Point endPoint) {
        return Math.abs(startPoint.getX() - endPoint.getX()) + Math.abs(startPoint.getY() - endPoint.getY());
    }
}
