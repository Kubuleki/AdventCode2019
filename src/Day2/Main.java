package Day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Krystian Cegiełka
 * Advent of Code 2019 - Day 2
 * https://adventofcode.com/2019/day/2
 */
public class Main {
    public static void main(String[] args) throws IOException {
        test();

        // Tworzenie danych z pliku
        BufferedReader br = new BufferedReader(new FileReader(new File("./src/Day2/input.txt")));
        String[] separated = br.readLine().split(",");

        //Tworzenie ciągu.
        int[] input = new int[separated.length];
        for (int i = 0; i < separated.length; i++) {
            input[i] = Integer.parseInt(separated[i]);
        }

        System.out.println("\tANSWERS:");
        //Rozwiązanie 1 części zadania
        input[1] = 12;
        input[2] = 2;
        System.out.println("Value on the position[0]: " + calculateOpcodes(input.clone()));

        //Sprawdzanie verba i neuna, żeby osiągnąć 19690720
        int Noun = 0;
        int Verb = 0;
        lookingForAnswer:
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                input[1] = i;
                input[2] = j;
                if (calculateOpcodes(input.clone()) == 19690720) {
                    Noun = input[1];
                    Verb = input[2];
                    continue lookingForAnswer;
                }
            }
        }
        System.out.println("100 * noun + verb = " + getAnswer(Noun, Verb));
    }

    /**
     * Method Calculate Opcode
     *
     * @param input Table of integers contains orders.
     * @return Calculated output.
     */
    private static int calculateOpcodes(int[] input) {
        for (int i = 0; i < input.length - input.length % 4; i += 4) {
            Opcode op = new Opcode(input[i], input[i + 1], input[i + 2], input[i + 3]);
            input = op.change(input);
        }
        return input[0];
    }

    /**
     * Method calculate answer for part 2 of the task.
     *
     * @param noun Integer on the position [1] of input table.
     * @param verb Integer on the position [2] of input table.
     * @return Answer for part 2 of the task.
     */
    private static int getAnswer(int noun, int verb) {
        return 100 * noun + verb;
    }

    /**
     * Test, if program works correctly, based on examples in task description.
     */
    public static void test() {
        int[] input = {1, 9, 10, 3, 2, 3, 11, 0, 99, 30, 40, 50};
        System.out.println("\tTEST:");

        //Part 1:
        System.out.println("Answer should be 3500.");
        System.out.println("Value on the position[0]: " + calculateOpcodes(input.clone()));
        System.out.println(calculateOpcodes(input.clone()) == 3500 ? "Test 1 passed.\n" : "Test 1 failed.\n");

        //Part 2:
        System.out.println("Neun should be 5, Verb 2, index 0 value 250, answer 502");
        int Noun = 0;
        int Verb = 0;
        lookingForAnswer:
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                input[1] = i;
                input[2] = j;
                if (calculateOpcodes(input.clone()) == 250) {
                    Noun = input[1];
                    Verb = input[2];
                    continue lookingForAnswer;
                }
            }
        }
        System.out.println("100 * noun + verb = " + getAnswer(Noun, Verb));
        System.out.println(getAnswer(Noun, Verb) == 502 ? "Test 2 passed.\n" : "Test 2 failed.\n");
    }
}