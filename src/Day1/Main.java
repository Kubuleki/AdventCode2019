package Day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\kryceg01\\IdeaProjects\\AdventCode2019\\src\\Day1\\input.txt")));
        int sum = 0;
        String input;
        while((input = br.readLine()) != null){
            sum += calculateFuel(Integer.parseInt(input));
        }
        System.out.println(sum);
    }
    private static int calculateFuel(int mass){
        return mass >= 9 ? mass / 3 - 2 + calculateFuel(mass / 3 - 2):0;
    }
}
