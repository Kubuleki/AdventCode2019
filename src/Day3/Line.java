package Day3;

/**
 * Line between two Points.
 */
public class Line {
    private Point startPoint;
    private Point endPoint;
    private boolean horizontal;

    /**
     * Constructor of Line class based on direction and length.
     *
     * @param startPoint Point with coordinates where Line starts.
     * @param direction  Direction where Line goes.
     * @param length     Length of the Line.
     */
    public Line(Point startPoint, Direction direction, int length) {
        this.startPoint = startPoint;
        switch (direction) {
            case D:
                this.endPoint = new Point(this.startPoint.getX(), this.startPoint.getY() - length);
                break;
            case U:
                this.endPoint = new Point(this.startPoint.getX(), this.startPoint.getY() + length);
                break;
            case L:
                this.endPoint = new Point(this.startPoint.getX() - length, this.startPoint.getY());
                break;
            case R:
                this.endPoint = new Point(this.startPoint.getX() + length, this.startPoint.getY());
                break;
            default:
                System.out.println("Something went wrong.");
                break;
        }
        this.horizontal = startPoint.getY() == endPoint.getY();
    }

    /**
     * Constructor of Line based on start and end Points.
     *
     * @param startPoint StartPoint of Line.
     * @param endPoint   EndPoint of Line.
     */
    public Line(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.horizontal = startPoint.getY() == endPoint.getY();
    }

    /**
     * Method returns StartPoint.
     *
     * @return Point where Line starts.
     */
    public Point getStartPoint() {
        return startPoint;
    }

    /**
     * Method returns EndPoint.
     *
     * @return Point where Line ends.
     */
    public Point getEndPoint() {
        return endPoint;
    }

    /**
     * Method check if Line is horizontal.
     *
     * @return Returns true if Line is horizontal.
     */
    public boolean isHorizontal() {
        return horizontal;
    }

    /**
     * Method returns of new Line ascending right or up.
     *
     * @return New directed Line.
     */
    public Line getItselfStraigth() {
        if (getStartPoint().getX() <= getEndPoint().getX() && getStartPoint().getY() <= getEndPoint().getY()) {
            return new Line(getStartPoint(), getEndPoint());
        } else return new Line(getEndPoint(), getStartPoint());
    }

    /**
     * String representation of Line.
     *
     * @return String representation of Line.
     */
    @Override
    public String toString() {
        return (isHorizontal() ? "Horizontal" : "Vertical") + " line from [" + startPoint.getX() + "," + startPoint.getY() + "] to [" + endPoint.getX() + "," + endPoint.getY() + "].\n";
    }
}
