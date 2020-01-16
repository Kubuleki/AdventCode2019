package Day4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Krystian Cegiełka
 * Advent of Code 2019 - Day 4
 * https://adventofcode.com/2019/day/4
 */
public class Main {
    public static void main(String[] args) throws IOException {
        //Tworzenie inputa.
        BufferedReader br = new BufferedReader(new FileReader(new File(".\\src\\Day4\\input.txt")));
        String[] input = br.readLine().split("-");

        //Tworzenie zakresu
        final int MINUMUM = Integer.parseInt(input[0]);
        final int MAXIMUM = Integer.parseInt(input[1]);
        int counter1 = 0;
        int counter2 = 0;

        //Obliczanie wyniku
        for (int i = MINUMUM; i <= MAXIMUM; i++) {
            counter1 = test1(i) ? counter1 + 1 : counter1;
            counter2 = test2(i) ? counter2 + 1 : counter2;
        }
        test();
        System.out.println("There are " + counter1 + " out of " + (MAXIMUM - MINUMUM + 1) + " passwords that meets criteria given in part 1.");
        System.out.println("There are " + counter2 + " passwords meets criteria given in part 2.");

    }

    /**
     * Test, if program works correctly, based on examples.
     */
    public static void test() {
        //PART 1
        // Test potentially good passwords
        boolean goodPasswordTest1Result = test1(112345, true);
        goodPasswordTest1Result = test1(111344, true) && goodPasswordTest1Result;
        goodPasswordTest1Result = test1(113444, true) && goodPasswordTest1Result;
        goodPasswordTest1Result = test1(112233, true) && goodPasswordTest1Result;
        goodPasswordTest1Result = test1(111133, true) && goodPasswordTest1Result;
        goodPasswordTest1Result = test1(113333, true) && goodPasswordTest1Result;
        System.out.println("CORRECT PASSWORD TEST 1: " + (goodPasswordTest1Result ? "PASSED.\n" : "FAILED.\n"));

        // Test potentially bad passwords.
        boolean badPasswordTest1Result = test1(123456, false);
        badPasswordTest1Result = test1(113311, false) && badPasswordTest1Result;
        badPasswordTest1Result = test1(113465, false) && badPasswordTest1Result;
        System.out.println("INCORRECT PASSWORD TEST 1: " + (badPasswordTest1Result ? "PASSED.\n" : "FAILED.\n"));

        //PART 2
        // Test potentially good passwords
        boolean goodPasswordTest2Result = test2(112345, true);
        goodPasswordTest2Result = test2(111344, true) && goodPasswordTest2Result;
        goodPasswordTest2Result = test2(113444, true) && goodPasswordTest2Result;
        goodPasswordTest2Result = test2(112233, true) && goodPasswordTest2Result;
        goodPasswordTest2Result = test2(111133, true) && goodPasswordTest2Result;
        goodPasswordTest2Result = test2(113333, true) && goodPasswordTest2Result;
        System.out.println("CORRECT PASSWORD TEST 2: " + (goodPasswordTest2Result ? "PASSED.\n" : "FAILED.\n"));

        // Test potentially bad passwords.
        boolean badPasswordTest2Result = test2(111112, false);
        badPasswordTest2Result = test2(111123, false) && badPasswordTest2Result;
        badPasswordTest2Result = test2(111111, false) && badPasswordTest2Result;
        badPasswordTest2Result = test2(123456, false) && badPasswordTest2Result;
        badPasswordTest2Result = test2(113311, false) && badPasswordTest2Result;
        badPasswordTest2Result = test2(113465, false) && badPasswordTest2Result;
        badPasswordTest2Result = test2(111345, false) && badPasswordTest2Result;
        System.out.println("INCORRECT PASSWORD TEST 2: " + (badPasswordTest2Result ? "PASSED.\n" : "FAILED.\n"));

        System.out.println("*****************************");
        System.out.println("* TEST PASSWORDS:\t" + (goodPasswordTest1Result && badPasswordTest1Result && goodPasswordTest2Result && badPasswordTest2Result ? "PASSED." : "FAILED.") + " *");
        System.out.println("*****************************\n");
    }

    /**
     * Method checks if password meets criteria given in part 1.
     *
     * @param input      Password.
     * @param shouldPass Boolean if this password should or shouldn't pass test.
     * @return Returns boolean if result of test is same, as expected result.
     */
    public static boolean test1(int input, boolean shouldPass) {
        boolean output = test1(input) == shouldPass;
        System.out.print((shouldPass ? "Test dobrego" : "Test złego") + " hasła " + input + " przebiegł:\t");
        System.out.println(output ? "pomyślnie." : "nie pomyślnie.");
        if (!output) {
            System.out.println("\tHave double: " + haveDouble(input) + ", is non-decrease: " + isNonDecrease(input));
        }
        return output;
    }

    /**
     * Method checks if password meets criteria given in part 2.
     *
     * @param input      Password.
     * @param shouldPass Boolean if this password should or shouldn't pass test.
     * @return Returns boolean if result of test is same, as expected result.
     */
    public static boolean test2(int input, boolean shouldPass) {
        boolean output = test2(input) == shouldPass;
        System.out.print((shouldPass ? "Test dobrego" : "Test złego") + " hasła " + input + " przebiegł:\t");
        System.out.println(output ? "pomyślnie." : "nie pomyślnie.");
        if (!output) {
            System.out.println("\tHave double: " + haveExactlyDouble(input) + ", is non-decrease: " + isNonDecrease(input));
        }
        return output;
    }

    /**
     * Actual method to check conditions given in task description (for part 1).
     *
     * @param input Password.
     * @return Returns boolean if password meets given criteria.
     */
    public static boolean test1(int input) {
        return haveDouble(input) && isNonDecrease(input);
    }

    /**
     * Actual method to check conditions given in task description (for part 2).
     *
     * @param input Password.
     * @return Returns boolean if password meets given criteria.
     */
    public static boolean test2(int input) {
        return haveExactlyDouble(input) && isNonDecrease(input);
    }

    /**
     * Method checks if password have 2 same digits in row.
     *
     * @param input Password.
     * @return Returns if password have pair of digits.
     */
    public static boolean haveDouble(int input) {
        int currentDigit = 0;
        do {
            if (input % 10 == currentDigit) return true;
            else {
                currentDigit = input % 10;
                input /= 10;
            }
        } while (currentDigit != 0);
        return false;
    }

    /**
     * Check if password have at least one pair of digits, which are not part of larger group.
     *
     * @param input Password.
     * @return Returns boolean if password have at least one pair of digits, which are not part of larger group.
     */
    public static boolean haveExactlyDouble(int input) {
        String inputAsString = "" + input;
        boolean haveExactlyDouble = false;
        int currentDigit = inputAsString.charAt(0);
        int largeGroupDigit = 0;
        for (int i = 1; i < inputAsString.length(); i++) {
            boolean isEqualPrevious = inputAsString.charAt(i) == currentDigit;
            if (!haveExactlyDouble && isEqualPrevious && currentDigit != largeGroupDigit) {
                haveExactlyDouble = true;
            } else if (haveExactlyDouble && isEqualPrevious) {
                haveExactlyDouble = false;
                largeGroupDigit = currentDigit;
            } else if (haveExactlyDouble) {
                return true;
            }
            currentDigit = inputAsString.charAt(i);
        }
        return haveExactlyDouble;
    }

    /**
     * Method checks if password have only non-decrease digits.
     *
     * @param input Password to check.
     * @return Returns boolean if input is nonDecrease.
     */
    public static boolean isNonDecrease(int input) {
        String inputAsString = "" + input;
        boolean isNonDecrease = true;
        for (int i = 1; i < inputAsString.length(); i++) {
            if (inputAsString.charAt(i - 1) > inputAsString.charAt(i)) {
                isNonDecrease = false;
                break;
            }
        }
        return isNonDecrease;
    }
}
