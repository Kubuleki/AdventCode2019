package Day6;

import java.util.HashMap;

public class Computer {
    public static void printHashMap(HashMap<String, Node<String>> map) {
        for (Node<String> node : map.values()) {
            node.printInfo();
        }
    }

    public static long calculateAllDistances(Node<String> node, long distance) {
        node.printInfo();
        System.out.println("Distance until now: " + distance);
        long distanceTmp = 0;
        for (Node<String> child : node.getChildren()) {
            distanceTmp += calculateAllDistances(child, distance + 1);
        }
        return distance + distanceTmp;
    }

    public static long calculateDistance(Node<String> from, Node<String> to) {
        HashMap<String, Node<String>> pathFrom = makePathToCOM(from);
        HashMap<String, Node<String>> pathTo = makePathToCOM(to);
        return calculateDistance(from, pathTo, 0) + calculateDistance(to, pathFrom, 0);
    }

    public static long calculateDistance(Node<String> from, HashMap<String, Node<String>> map, long distance){
        if(!map.containsKey(from.getParent().getData())){
            return calculateDistance(from.getParent(), map, ++distance);
        } else {
            return distance;
        }
    }

    public static void printPathToCOM(Node<String> node) {
        HashMap<String, Node<String>> map = makePathToCOM(node);
        map.forEach((k, v) -> System.out.print(v.getData() + " - "));
        System.out.println();
    }

    //Powinno być na LinkedList
    public static HashMap<String, Node<String>> makePathToCOM(Node<String> node) {
        HashMap<String, Node<String>> map = new HashMap<>();
        map.put(node.getData(), node);
        if (node.getParent() != null) {
            makePathToCOM(node.getParent(), map);
        }
        return map;
    }

    //Powinno być na LinkedList
    public static HashMap<String, Node<String>> makePathToCOM(Node<String> node, HashMap<String, Node<String>> map) {
        map.put(node.getData(), node);
        if (node.getParent() != null) {
            makePathToCOM(node.getParent(), map);
        }
        return map;
    }
}
