package Day6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        // Prepare input data.
        BufferedReader br = new BufferedReader(new FileReader(new File(".//src//Day6//input.txt")));
        HashMap<String, Node<String>> galaxyMap = new HashMap<>();
        String nextLine = br.readLine();
        while (nextLine != null) {
            String[] data = nextLine.split("\\)");
            if (!galaxyMap.containsKey(data[0])) {
                galaxyMap.put(data[0], new Node<>(data[0]));
            }
            if (!galaxyMap.containsKey(data[1])) {
                galaxyMap.put(data[1], new Node<>(data[1], galaxyMap.get(data[0])));
            } else {
                galaxyMap.get(data[0]).addChild(galaxyMap.get(data[1]));
                galaxyMap.get(data[1]).setParent(galaxyMap.get(data[0]));
            }
            nextLine = br.readLine();
        }
        Computer.printHashMap(galaxyMap);
        System.out.println("Distance: " + Computer.calculateDistance(galaxyMap));
    }
}
