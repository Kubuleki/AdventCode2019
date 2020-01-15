package Day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Krystian Cegiełka
 * Advent of Code 2019 - Day 1
 * https://adventofcode.com/2019/day/1
 */
public class Main {
    public static void main(String[] args) throws IOException {
        test();
        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\kryceg01\\IdeaProjects\\AdventCode2019\\src\\Day1\\input.txt")));
        int sum = 0;
        int sumRecursive = 0;
        String input;
        while ((input = br.readLine()) != null) {
            sum += calculateFuel(Integer.parseInt(input));
            sumRecursive += calculateFuelRecursive(Integer.parseInt(input));
        }
        System.out.println("\tANSWERS:");
        System.out.println("Sum of the fuel requirements for all of the modules: " + sum);
        System.out.println("Sum of the fuel requirements for all of the modules, including weight of the fuel itself: " + sumRecursive);
    }

    /**
     * Give answer for part 1
     *
     * @param mass Fuel needs to transport.
     * @return Calculated ammount of fuel needs to transport.
     */
    private static int calculateFuel(int mass) {
        return mass >= 9 ? mass / 3 - 2 : mass;
    }

    /**
     * Give answer for part 2.
     *
     * @param mass Fuel needs to transport.
     * @return Calculated ammount of fuel needs to transport (included itself weight).
     */
    private static int calculateFuelRecursive(int mass) {
        return mass >= 9 ? mass / 3 - 2 + calculateFuelRecursive(mass / 3 - 2) : 0;
    }

    /**
     * Test, if program works correctly, based on examples in task description.
     */
    private static void test() {
        System.out.println("\tTEST:");

        // Part 1:
        // in 100756, out should be 33583
        System.out.println(calculateFuel(100756));
        System.out.println(calculateFuel(100756) == 33583 ? "Test 1 passed." : "Test 1 failed.");

        // Part 2:
        // in 100756, out should be 50346
        System.out.println(calculateFuelRecursive(100756));
        System.out.println(calculateFuelRecursive(100756) == 50346 ? "Test 2 passed." : "Test 2 failed.");
    }
}
