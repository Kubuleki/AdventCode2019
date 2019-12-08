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
            counter = test(i) ? counter+1 : counter;
        }
        System.out.println("Jest " + counter + " możliwych kombinacji, na " + (MAXIMUM - MINUMUM + 1) + " sprawdzonych haseł.");
        System.out.println("Test dobrego hasła: 112345: " + test(112345));
        System.out.println("Test złego hasła: 123456" + test(123456));
        System.out.println("Test złego hasła: 113465" + test(113465));
    }

    public static boolean test(int input) {
        return haveDouble(input) && isNonDecrease(input);
    }

    public static boolean haveDouble(int input) {
        String inputAsString = "" + input;
        boolean haveDouble = false;
        for (int i = 1; i < inputAsString.length(); i++) {
            if (inputAsString.charAt(i - 1) == inputAsString.charAt(i)) {
                haveDouble = true;
            }
        }
        return haveDouble;
    }

    public static boolean isNonDecrease(int input){
        String inputAsString = "" + input;
        boolean isNonDecrease = true;
        for (int i = 1; i < inputAsString.length(); i++) {
            if (inputAsString.charAt(i - 1) > inputAsString.charAt(i)) {
                isNonDecrease = false;
            }
        }
        return isNonDecrease;
    }
}
