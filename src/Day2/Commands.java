package Day2;

/**
 * Auxiliary enum Command types.
 */
public enum Commands {
    ADDITION(1),
    MULTIPLICATION(2),
    QUIT(99);


    private final int value;

    /**
     * Constructor of enum Commands.
     *
     * @param value Integer representation of command type.
     */
    Commands(final int value) {
        this.value = value;
    }

    /**
     * Constructor for commands via integer.
     *
     * @param value Integer representation of command type.
     * @return Command type represented by integer value.
     */
    public static Commands fromInt(int value) {
        for (Commands c : Commands.values()) {
            if (c.getValue() == value) {
                return c;
            }
        }
        return Commands.QUIT;
    }

    /**
     * Method returns integer representation of command type.
     *
     * @return Integer representation of command type.
     */
    public int getValue() {
        return value;
    }
}
