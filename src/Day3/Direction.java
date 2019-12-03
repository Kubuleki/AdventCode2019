package Day3;

public enum Direction {
    U("UP"),
    R("RIGHT"),
    D("DOWN"),
    L("LEFT");

    public final String label;

    Direction(String label){
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
