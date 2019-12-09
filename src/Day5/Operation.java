package Day5;

public class Operation {
    private int input;
    private int opcode;
    private int parameter1Mode;
    private int parameter2Mode;
    private int parameter3Mode;

    public Operation(int input) {
        this.input = input;
        this.opcode = input % 100;
        this.parameter1Mode = input / 100 % 2;
        this.parameter2Mode = input / 1000 % 2;
        this.parameter3Mode = input / 10000 % 2;
    }

    public int getOpcode() {
        return opcode;
    }

    public int getParameter1Mode() {
        return parameter1Mode;
    }

    public int getParameter2Mode() {
        return parameter2Mode;
    }

    public int getParameter3Mode() {
        return parameter3Mode;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "input=" + input +
                "opcode=" + opcode +
                ", parameter1Mode=" + parameter1Mode +
                ", parameter2Mode=" + parameter2Mode +
                ", parameter3Mode=" + parameter3Mode +
                '}';
    }
}
