package Day3;

/**
 * Auxiliary enum class.
 */
public enum Direction {
    U("UP"),
    R("RIGHT"),
    D("DOWN"),
    L("LEFT");

    public final String label;

    /**
     * Constructor of enum Class.
     *
     * @param label String representation of Direction.
     */
    Direction(String label) {
        this.label = label;
    }

    /**
     * Returns String representation of direction.
     *
     * @return String representation of direction.
     */
    @Override
    public String toString() {
        return label;
    }
}
