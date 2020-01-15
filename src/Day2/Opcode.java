package Day2;

/**
 * Opcode represented by command type and 3 index integers.
 */
public class Opcode {
    private Commands command;
    private int firstIndex;
    private int secondIndex;
    private int outputIndex;

    /**
     * Constructor of Opcode class.
     *
     * @param command     Type of command.
     * @param firstIndex  Index of first integer.
     * @param secondIndex Index of second integer.
     * @param outputIndex Index of output integer.
     */
    public Opcode(int command, int firstIndex, int secondIndex, int outputIndex) {
        this.command = Commands.fromInt(command);
        this.firstIndex = firstIndex;
        this.secondIndex = secondIndex;
        this.outputIndex = outputIndex;
    }

    /**
     * Method returns type of command.
     *
     * @return Type of command.
     */
    public Commands getCommand() {
        return command;
    }

    /**
     * Method returns index of first integer.
     *
     * @return Index of first integer.
     */
    public int getFirstIndex() {
        return firstIndex;
    }

    /**
     * Method returns index of second integer.
     *
     * @return Index of second integer.
     */
    public int getSecondIndex() {
        return secondIndex;
    }

    /**
     * Method returns index of output integer.
     *
     * @return Index of output integer.
     */
    public int getOutputIndex() {
        return outputIndex;
    }

    /**
     * Method do changes on the input table based on given command and variable indexes.
     *
     * @param input Input table of integers.
     * @return Changed table of integers.
     */
    public int[] change(int[] input) {
        if (outputIndex < input.length && firstIndex < input.length && secondIndex < input.length) {
            switch (getCommand()) {
                case ADDITION:
                    input[getOutputIndex()] = input[getFirstIndex()] + input[getSecondIndex()];
                    break;
                case MULTIPLICATION:
                    input[getOutputIndex()] = input[getFirstIndex()] * input[getSecondIndex()];
                    break;
                case QUIT:
                    break;
                default:
                    System.out.println("Unknown command.");
            }
        }
        return input;
    }

    /**
     * Overrided toString to tests.
     *
     * @return String representation of Opcode object.
     */
    @Override
    public String toString() {
        return "Opcode{" +
                "command=" + command +
                ", firstIndex=" + firstIndex +
                ", secondIndex=" + secondIndex +
                ", outputIndex=" + outputIndex +
                '}';
    }
}
