package Day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
            //Tworzenie obiektów na podstawie danych z pliku input.txt.
        BufferedReader br = new BufferedReader(new FileReader(new File(".\\src\\Day3\\input.txt")));
        Wire wire1 = new Wire(br.readLine().split(","));
        Wire wire2 = new Wire(br.readLine().split(","));

    }
}
