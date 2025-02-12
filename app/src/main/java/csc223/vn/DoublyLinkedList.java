package csc223.vn;
public class DoublyLinkedList extends SinglyLinkedList{
    public Node tail;
    
    public DoublyLinkedList() {
    super();
    this.tail = null;
    }
    @Override
    public void insert(char item) {
    super.insert(item);
    if(tail == null) {
    tail = head;
    } else {
    Node newNode = new Node(item);
    tail.next = newNode;
    newNode.previous = tail;
    tail = newNode;
    }
    }
    
    public static void main(String[] args){
    DoublyLinkedList list = new DoublyLinkedList();
    list.insert('A');
    list.insert('B');
    list.insert('C');
    
    Node curr = list.head;
    if(curr == null) {
    System.out.println("List is empty.");
    } else {
    System.out.println("List contains: ");
    while(curr != null) {
    System.out.print(curr.data + " ");
    curr = curr.next;
    }
    System.out.println();
    }
    }
    }