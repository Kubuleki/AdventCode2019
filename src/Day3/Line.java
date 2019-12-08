package Day3;

public class Line {
    private Point startPoint;
    private Point endPoint;
    private boolean horizontal;

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
                System.out.println("Something went very wrong motherfucka.");
                break;
        }
        setHorizontal();
    }

    public Line(Point startPoint, Point endPoint, boolean horizontal) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.horizontal = horizontal;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }


    public boolean isHorizontal() {
        return horizontal;
    }

    public void setHorizontal() {
        this.horizontal = startPoint.getY() == endPoint.getY();
    }

    public Line getItselfStraigth() {
        if (getStartPoint().getX() <= getEndPoint().getX() && getStartPoint().getY() <= getEndPoint().getY()) {
            return new Line(getStartPoint(), getEndPoint(), horizontal);
        } else return new Line(getEndPoint(), getStartPoint(), horizontal);
    }

    @Override
    public String toString() {
        return (isHorizontal() ? "Horizontal" : "Vertical") + " line from " + startPoint.getX() + "," + startPoint.getY() + " to " + endPoint.getX() + "," + endPoint.getY() + "\n";
    }
}
