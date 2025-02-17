package csc223.vn;
public class Node {
    char data;
    Node next;
    Node previous;
    
    public Node(char data) {
    this.data = data;
    this.next = null;
    this.previous = null;
    }
    
    public static void main(String[] args) {
    Node firstNode = new Node('A');
    Node secondNode = new Node('B');
    Node thirdNode = new Node('C');
    firstNode.next = secondNode;
    secondNode.previous = firstNode;
    secondNode.next = thirdNode;
    thirdNode.previous = secondNode;
    
    Node curr = firstNode;
    while(curr != null) {
    System.out.print(curr.data + " ");
    curr = curr.next;
    }
    System.out.println();
    }
    }