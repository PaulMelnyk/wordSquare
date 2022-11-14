package model;

public class Node {
    public int val;
    public Node[] children;

    public Node() {
        children = new Node[26];
    }
    public Node(int val){
        this();
        this.val = val;
    }
}