package Day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/**
 * @author Krystian Cegiełka
 * Advent of Code 2019 - Day 3
 * https://adventofcode.com/2019/day/3
 */
public class Main {
    public static void main(String[] args) throws IOException {
        //Tworzenie obiektów na podstawie danych z pliku input.txt.
        BufferedReader br = new BufferedReader(new FileReader(new File(".\\src\\Day3\\input.txt")));

        //Tworzenie ścieżek.
        Wire wire1 = new Wire(br.readLine().split(","));
        Wire wire2 = new Wire(br.readLine().split(","));

        //Obliczanie odpowiedzi.
        Comparator.getAnswer(Comparator.getNodes(wire1, wire2));
        Comparator.getSecondAnswer(Comparator.getNodes(wire1, wire2));
    }
}
