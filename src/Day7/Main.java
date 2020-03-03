package Day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //Czytanie z pliku
        BufferedReader br = new BufferedReader(new FileReader(new File("./src/Day5/input.txt")));
        String[] separated = br.readLine().split(",");

        //Tworzenie ciągu.
        int[] inputs = new int[separated.length];
        for (int i = 0; i < separated.length; i++) {
            inputs[i] = Integer.parseInt(separated[i]);
        }
        //ID of system. This time is 1 for first part, 5 for second.
        System.out.print("First part answer: ");
        calculateResult(inputs.clone(), 1);
        System.out.println("Second part answer: ");
        calculateResult(inputs.clone(), 5);
    }

    private static void calculateResult(int[] inputs, int systemID) {
        Operation operation;
        forLoop:
        for (int i = 0; i < inputs.length; ) {
            operation = new Operation(inputs[i]);
            switch (operation.getOpcode()) {
                // p3 = p1 + p2
                case 1:
                    int a = operation.getParameter1Mode() == 1 ? inputs[i + 1] : inputs[inputs[i + 1]];
                    int b = operation.getParameter2Mode() == 1 ? inputs[i + 2] : inputs[inputs[i + 2]];
                    if (operation.getParameter3Mode() == 1) {
                        inputs[i + 3] = a + b;
                    } else {
                        inputs[inputs[i + 3]] = a + b;
                    }
                    i += 4;
                    break;
                // p3 = p1 * p2
                case 2:
                    a = operation.getParameter1Mode() == 1 ? inputs[i + 1] : inputs[inputs[i + 1]];
                    b = operation.getParameter2Mode() == 1 ? inputs[i + 2] : inputs[inputs[i + 2]];
                    if (operation.getParameter3Mode() == 1) {
                        inputs[i + 3] = a * b;
                    } else {
                        inputs[inputs[i + 3]] = a * b;
                    }
                    i += 4;
                    break;
                // p1 = input
                case 3:
                    if (operation.getParameter1Mode() == 1) {
                        inputs[i + 1] = systemID;
                    } else {
                        inputs[inputs[i + 1]] = systemID;
                    }
                    i += 2;
                    break;
                // sout(p1)
                case 4:
                    System.out.println(operation.getParameter1Mode() == 1 ? inputs[i + 1] : inputs[inputs[i + 1]]);
                    i += 2;
                    break;
                // if p1 != 0, i = p2
                case 5:
                    a = operation.getParameter1Mode() == 1 ? inputs[i + 1] : inputs[inputs[i + 1]];
                    if (a != 0) {
                        i = operation.getParameter2Mode() == 1 ? inputs[i + 2] : inputs[inputs[i + 2]];
                    } else {
                        i += 3;
                    }
                    break;
                // if p1 == 0, i = p2
                case 6:
                    a = operation.getParameter1Mode() == 1 ? inputs[i + 1] : inputs[inputs[i + 1]];
                    if (a == 0) {
                        i = operation.getParameter2Mode() == 1 ? inputs[i + 2] : inputs[inputs[i + 2]];
                    } else {
                        i += 3;
                    }
                    break;
                // if p1 < p2; p3=1, else p3=0
                case 7:
                    a = operation.getParameter1Mode() == 1 ? inputs[i + 1] : inputs[inputs[i + 1]];
                    b = operation.getParameter2Mode() == 1 ? inputs[i + 2] : inputs[inputs[i + 2]];
                    if (operation.getParameter3Mode() == 1) {
                        inputs[i + 3] = a < b ? 1 : 0;
                    } else {
                        inputs[inputs[i + 3]] = a < b ? 1 : 0;
                    }
                    i += 4;
                    break;
                // if p1 == p2; p3=1, else p3=0
                case 8:
                    a = operation.getParameter1Mode() == 1 ? inputs[i + 1] : inputs[inputs[i + 1]];
                    b = operation.getParameter2Mode() == 1 ? inputs[i + 2] : inputs[inputs[i + 2]];
                    if (operation.getParameter3Mode() == 1) {
                        inputs[i + 3] = a == b ? 1 : 0;
                    } else {
                        inputs[inputs[i + 3]] = a == b ? 1 : 0;

                    }
                    i += 4;
                    break;
                // Finish the program.
                case 99:
                    break forLoop;
                default:
                    System.out.println("Something goes wrong: " + operation.getOpcode());
                    break;
            }
        }
    }
}
