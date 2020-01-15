package Day3;

import java.util.ArrayList;
import java.util.List;

/**
 * Full path beetween 2 points.
 */
public class Wire {
    List<Line> lines = new ArrayList<>();
    Point currentPoint = new Point(0, 0);

    /**
     * Constructor of Wire.
     *
     * @param lines Table of Strings which will be list of Lines.
     */
    public Wire(String[] lines) {
        for (String string : lines) {
            Direction direction = Direction.valueOf(string.substring(0, 1));
            int length = Integer.parseInt(string.substring(1));
            Line line = new Line(currentPoint, direction, length);
            this.lines.add(line);
            currentPoint = line.getEndPoint();
        }
    }

    /**
     * Print all lines.
     *
     * @return String of all lines.
     */
    @Override
    public String toString() {
        return "" + lines;
    }

    /**
     * Returns list of Lines.
     *
     * @return Returns list of Lines.
     */
    public List<Line> getLines() {
        return lines;
    }
}
