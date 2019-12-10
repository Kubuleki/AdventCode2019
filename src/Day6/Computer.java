package Day6;

import java.util.HashMap;

public class Computer {
    public static void printHashMap(HashMap<String, Node<String>> map) {
        for (Node<String> node : map.values()) {
            node.printInfo();
        }
    }

    public static long calculateDistance(Node<String> node, long distance) {
        node.printInfo();
        System.out.println("Distance until now: " + distance);
        long distanceTmp = 0;
        for (Node<String> child : node.getChildren()) {
            distanceTmp += calculateDistance(child, distance + 1);
        }
        return distance + distanceTmp;
    }


}
