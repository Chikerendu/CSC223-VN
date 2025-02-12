package csc223.vn;
public class SortedLinkedList extends DoublyLinkedList {
    private Node head;
public SortedLinkedList() {
    super();
    }
    
    @Override
    public void insert(char item) {
    Node newNode = new Node(item);
    if(head == null) {
    head = tail = newNode;
    } else {
    Node temp = head;
    Node prev = null;
    while(temp != null && temp.data > item) {
    prev = temp;
    temp = temp.next;
    }
    if(prev == null) {
    newNode.next = head;
    head.previous = newNode;
    head = newNode;
    } else {
    prev.next = newNode;
    newNode.previous = prev;
    newNode.next = temp;
    if(temp != null) {
    temp.previous = newNode;
    } else {
    tail = newNode;
    }
    }
    }
    size++;
    }
    
    
    public static void main(String[] args) {
    SortedLinkedList list = new SortedLinkedList();
    
    list.insert('D');
    list.insert('B');
    list.insert('A');
    list.insert('C');
    System.out.println("List after inserting DBAC: " + list.toString());
    System.out.println("First part: " + list.getFirst());
    System.out.println("Last part: " + list.getLast());
    
    System.out.println("The size of list: " + list.size());
    
    list.remove('B');
    System.out.println("List after removing B: " + list.toString());
    
    System.out.println("Does the list have 'B'? " + list.contains('B'));
    System.out.println("Does the list have 'C'? " + list.contains('C'));
    
    System.out.println("Index of 'C': " + list.indexOf('C'));
    System.out.println("Last index of 'C': " + list.lastIndexOf('C'));
    
    list.reverse();
    System.out.println("List after reversing: " + list.toString());
    
    list.clear();
    System.out.println("List after clearing: " + list.toString());
    }
}
