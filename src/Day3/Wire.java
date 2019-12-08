package Day3;

import java.util.ArrayList;
import java.util.List;

public class Wire {
    List<Line> lines = new ArrayList<>();
    Point currentPoint = new Point(0, 0);

    public Wire(String[] lines) {
        for (String string : lines) {
            Direction direction = Direction.valueOf(string.substring(0, 1));
            int length = Integer.parseInt(string.substring(1));
            Line line = new Line(currentPoint, direction, length);
            this.lines.add(line);
            currentPoint = line.getEndPoint();
        }
    }

    @Override
    public String toString() {
        return "" + lines;
    }

    public List<Line> getLines() {
        return lines;
    }
}
