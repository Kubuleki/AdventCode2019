package Day6;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {
    private List<Node<T>> children = new ArrayList<>();
    private Node<T> parent = null;
    private T data;

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Node<T> parent) {
        this.data = data;
        this.parent = parent;
        parent.addChild(this);
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public void addChild(Node<T> child) {
        child.setParent(this);
        this.children.add(child);
    }

    public T getData() {
        return this.data;
    }

    public boolean isRoot() {
        return this.parent == null;
    }

    public void printInfo() {
        System.out.print("NODE:\t" + this.data);
        if (!isRoot()) {
            System.out.print("\tPARENT:\t" + this.parent.getData());
        } else {
            System.out.print("\tThis is ROOT.");
        }
        System.out.print("\tChildren count: " + children.size());
        for (Node<T> n : children) {
            System.out.print("\t" + n.getData());
        }
        System.out.println();
    }
}