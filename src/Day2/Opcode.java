package Day2;

public class Opcode {
    private int command;
    private int firstIndex;
    private int secondIndex;
    private int outputIndex;

    public Opcode(int command, int firstIndex, int secondIndex, int outputIndex) {
        this.command = command;
        this.firstIndex = firstIndex;
        this.secondIndex = secondIndex;
        this.outputIndex = outputIndex;
    }

    public int getCommand() {
        return command;
    }

    public int getFirstIndex() {
        return firstIndex;
    }

    public int getSecondIndex() {
        return secondIndex;
    }

    public int getOutputIndex() {
        return outputIndex;
    }

    public int[] change(int[] input) {
        if (outputIndex < input.length && firstIndex < input.length && secondIndex < input.length) {
            switch (getCommand()) {
                case 1:
                    input[getOutputIndex()] = input[getFirstIndex()] + input[getSecondIndex()];
                    break;
                case 2:
                    input[getOutputIndex()] = input[getFirstIndex()] * input[getSecondIndex()];
                    break;
                case 99:
                    //System.out.println("Program ends. Final value of index 0 is: " + input[0]);
                    break;
                default:
                    System.out.println("Unknown command.");
            }
        }
        return input;
    }

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
