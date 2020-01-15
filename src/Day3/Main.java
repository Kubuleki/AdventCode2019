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
    //Tak działają zmienne statyczne:
    private static int testCounter = 0;

    public static void main(String[] args) throws IOException {
        //test();

        //Tworzenie obiektów na podstawie danych z pliku input.txt.
        BufferedReader br = new BufferedReader(new FileReader(new File(".\\src\\Day3\\input.txt")));

        //Tworzenie ścieżek.
        Wire wire1 = new Wire(br.readLine().split(","));
        Wire wire2 = new Wire(br.readLine().split(","));

        //Obliczanie odpowiedzi.
        Comparator.getAnswer(Comparator.getNodes(wire1, wire2));
        Comparator.getSecondAnswer(Comparator.getNodes(wire1, wire2));
    }

    public static void test() {
        useTest("R8,U5,L5,D3", "U7,R6,D4,L4", 6, 30);
        useTest("R75,D30,R83,U83,L12,D49,R71,U7,L72", "U62,R66,U55,R34,D71,R55,D58,R83", 159, 610);
        useTest("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51", "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7", 135, 410);
    }

    public static void useTest(String str1, String str2, int ans1, int ans2) {
        //Tworzenie ścieżek:
        Wire wire1 = new Wire(str1.split(","));
        Wire wire2 = new Wire(str2.split(","));

        //Obliczanie odpowiedzi:
        //Uzycie zmiennej statycznej (wspólnej dla wszystkich testów).
        System.out.println("\tTEST #" + ++testCounter + ":");

        System.out.println("Odpowiedź powinna być " + ans1 + ".");
        Comparator.getAnswer(Comparator.getNodes(wire1, wire2));
        System.out.println("Odpowiedź powinna być " + ans2 + ".");
        Comparator.getSecondAnswer(Comparator.getNodes(wire1, wire2));
    }
}
