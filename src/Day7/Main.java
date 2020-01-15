package Day7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //Czytanie z pliku
        BufferedReader br = new BufferedReader(new FileReader(new File("./src/Day5/input.txt")));
        String[] separated = br.readLine().split(",");
    }
}
