package Day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("./src/Day2/input.txt")));
        String[] separated = br.readLine().split(",");
        int[] input = new int[separated.length];
        for (int i = 0; i < separated.length; i++) {
            input[i] = Integer.parseInt(separated[i]);
        }

        //Sprawdzanie verba i neuna, żeby osiągnąć 19690720
        Point point = new Point(0, 0, false);
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                input[1] = i;
                input[2] = j;
                if (calculateOpcodes(input.clone()) == 19690720) {
                    point = new Point(i, j, true);
                    break;
                }
            }
            if (point.isFound()) {
                break;
            }
        }
        System.out.println("Odpowiedź to: " + getAnswer(point.getNoun(), point.getVerb()));
    }

    private static int calculateOpcodes(int[] input) {
        for (int i = 0; i < input.length - input.length % 4; i += 4) {
            Opcode op = new Opcode(input[i], input[i + 1], input[i + 2], input[i + 3]);
            input = op.change(input);
        }
        return input[0];
    }

    private static int getAnswer(int noun, int verb) {
        return 100 * noun + verb;
    }
}