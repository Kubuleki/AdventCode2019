package Day4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Tworzenie inputa.
        BufferedReader br = new BufferedReader(new FileReader(new File(".\\src\\Day4\\input.txt")));
        String[] input = br.readLine().split("-");
        final int MINUMUM = Integer.parseInt(input[0]);
        final int MAXIMUM = Integer.parseInt(input[1]);
        int counter = 0;
        for (int i = MINUMUM; i <= MAXIMUM; i++) {
            counter = test(i) ? counter + 1 : counter;
        }
        tester();
        System.out.println("Jest " + counter + " możliwych kombinacji, na " + (MAXIMUM - MINUMUM + 1) + " sprawdzonych haseł.");

    }

    public static boolean test(int input) {
        return haveExactlyDouble(input) && isNonDecrease(input);
    }

    public static boolean test(int input, boolean shouldPass) {
        boolean output = test(input) == shouldPass;
        System.out.print((shouldPass ? "Test dobrego" : "Test złego") + " hasła " + input + " przebiegł:\t");
        System.out.println(output ? "pomyślnie." : "nie pomyślnie.");
        if(!output){
            System.out.println("\tHED: " + haveExactlyDouble(input) + ", IND: " + isNonDecrease(input));
        }
        return output;
    }

    public static void tester() {
        // Test potentially good passwords
        boolean goodPasswordTestResult = test(112345, true);
        goodPasswordTestResult = goodPasswordTestResult && test(111344, true);
        goodPasswordTestResult = goodPasswordTestResult && test(113444, true);
        goodPasswordTestResult = goodPasswordTestResult && test(112233, true);
        goodPasswordTestResult = goodPasswordTestResult && test(111133, true);
        goodPasswordTestResult = goodPasswordTestResult && test(113333, true);

        // Test potentially bad passwords.
        boolean badPasswordTestResult = test(123456, false);
        badPasswordTestResult = badPasswordTestResult && test(113311, false);
        badPasswordTestResult = badPasswordTestResult && test(113465, false);
        badPasswordTestResult = badPasswordTestResult && test(111345, false);
        badPasswordTestResult = badPasswordTestResult && test(111444, false);

        System.out.println("\n Test dobrych haseł przebiegł:\t" + (goodPasswordTestResult ? "pomyślnie." : "niepomyślnie."));
        System.out.println("Test złych haseł przebiegł:\t" + (badPasswordTestResult ? "pomyślnie." : "niepomyślnie."));
        System.out.println("Poniższy wynik jest " + (goodPasswordTestResult && badPasswordTestResult ? "wiarygodny." : "niewiarygodny.\n"));
    }

    public static boolean haveExactlyDouble(int input) {
        String inputAsString = "" + input;
        boolean haveExactlyDouble = false;
        for (int i = 1; i < inputAsString.length(); i++) {
            boolean isEqualToPrevious = inputAsString.charAt(i - 1) == inputAsString.charAt(i);
            if (isEqualToPrevious) {
                haveExactlyDouble = true;
                if (i > 1) {
                    if (isEqualToPrevious && inputAsString.charAt(i - 2) == inputAsString.charAt(i)) {
                        haveExactlyDouble = false;
                    } else {
                        return true;
                    }
                }
            }
        }
        return haveExactlyDouble;
    }

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
