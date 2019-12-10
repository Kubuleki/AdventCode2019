package Day6;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Computer {
    public static void printHashMap(HashMap<String, Node<String>> map) {
        for (Node<String> node : map.values()){
            node.printInfo();
        }
    }
    public static int calculateDistance(HashMap<String, Node<String>> map){
        AtomicInteger output = new AtomicInteger();
            map.forEach((k,v)-> output.addAndGet(v.getChildren().size()));
                return output.get();
    }
}
