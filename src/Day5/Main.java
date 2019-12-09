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
        //ID of system. This time is 1
        int input = 1;
        Operation operation;
        forLoop:
        for (int i = 0; i < inputs.length; ) {
            operation = new Operation(inputs[i]);
            switch (operation.getOpcode()) {
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
                case 3:
                    if (operation.getParameter1Mode() == 1) {
                        inputs[i + 1] = input;
                    } else {
                        inputs[inputs[i + 1]] = input;
                    }
                    i += 2;
                    break;
                case 4:
                    System.out.println(operation.getParameter1Mode() == 1 ? inputs[i + 1] : inputs[inputs[i + 1]]);
                    i += 2;
                    break;
                case 99:
                    break forLoop;
                default:
                    System.out.println("Coś się zjebało " + operation.getOpcode());
                    break;
            }
        }
    }
}
