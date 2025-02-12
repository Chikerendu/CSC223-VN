
package csc223.vn;

public class SinglyLinkedList implements LinkedList {
    public Node head;
    public int size;
    public SinglyLinkedList() {
    this.head = null;
    this.size = 0;
    }
    public void insert(char item) {
    Node newNode = new Node(item);
    if(head == null) {
    head = newNode;
    } else{
    Node temp = head;
    while(temp.next != null){
    temp = temp.next;
    }
    temp.next = newNode;
    }
    size++;
    }
    @SuppressWarnings("null")
    public void remove(char item) {
    if(head == null) {
    return;
    }
    if(head.data == item) {
    head = head.next;
    size--;
    return;
    }
    Node temp = head;
    Node prev = null;
    
    while(temp != null) {
    if(temp.data == item) {
    break;
    }
    prev = temp;
    temp = temp.next;
    }
    if(temp != null) {
    prev.next = temp.next;
    size--;
    }
    }
    public char getFirst() {
    if(head != null){
    return 'X';
    }
    return head.data;
    }
    public char getLast() {
    if(head == null) {
    return 'X';
    }
    Node temp = head;
    while(temp.next != null) {
    temp = temp.next;
    }
    return temp.data;
    }
    public char get(int index) {
    if(index < 0 || index >= size) {
    return 'X';
    }
    Node temp = head;
    int count = 0;
    
    while(temp != null) {
    if(count == index){
    return temp.data;
    }
    count++;
    temp = temp.next;
    }
    return 'X';
    }
    public int size() {
    return size;
    }
    public boolean isEmpty() {
    return size == 0;
    }
    public void clear() {
    head = null;
    size = 0;
    }
    public boolean contains(char item) {
    Node temp = head;
    while(temp != null) {
    if(temp.data == item) {
    return true;
    }
    temp = temp.next;
    }
    return false;
    }
    public int indexOf(char item) {
    Node temp = head;
    int index = 0;
    
    while(temp != null) {
    if(temp.data == item) {
    return index;
    }
    index++;
    temp = temp.next;
    }
    return -1;
    }
    public int lastIndexOf(char item) {
    Node temp = head;
    int lastIndex = -1;
    int index = 0;
    
    while(temp != null) {
    if(temp.data == item) {
    lastIndex = index;
    }
    index++;
    temp = temp.next;
    }
    return lastIndex;
    }
    public void reverse() {
    Node prev = null;
    Node curr = head;
    Node next;
    
    while(curr != null) {
    next = curr.next;
    curr.next = prev;
    prev = curr;
    curr = next;
    }
    head = prev;
    }
    public String toString() {
    String result = "";
    Node temp = head;
    while(temp != null) {
    result += temp.data;
    temp = temp.next;
    }
    return result;
    }
    public static void main(String[] args) {
    SinglyLinkedList list = new SinglyLinkedList();
    
    list.insert('A');
    list.insert('B');
    list.insert('C');
    list.insert('D');
    System.out.println("List after inserting ABCD: " + list.toString());
    System.out.println("First part: " + list.getFirst());
    System.out.println("Last part: " + list.getLast());
    
    System.out.println("Element at index 2: " + list.get(2));
    
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
   