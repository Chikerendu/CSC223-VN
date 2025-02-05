
package csc223.vn;

public class ArrayQueue implements Queue {
    private int [] items;
    private int front, rear, count, capacity;

    public ArrayQueue(int size) {
        capacity = size;
        items = new int[capacity];
        front = 0;
        rear = -1;
        count = 0;
    }
    public void enqueue(int item) {
        if(count == capacity) {
            System.out.println("Queue is full");
            return;
        }
        rear = (rear + 1)% capacity;
        items[rear] = item;
        count++;
    }
    public int dequeue() {
        if(isEmpty()) {
            System.out.println("Can't dequeue");
            return -1;
        }
        int item = items[front];
        front = (front + 1)% capacity;
        count--;
        return item;
    }
    public int peek() {
        if(isEmpty()) {
            System.out.println("Nothing to peek.");
            return -1;
        }
        return items[front];
    }
    public boolean isEmpty() {
        return count == 0;
    }
    public int size() {
        return count;
    }
    
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Peek: " + queue.peek());
        System.out.println("Dequeue: " + queue.dequeue());  
        System.out.println("Dequeue: " + queue.dequeue());  
        System.out.println("Is queue empty? " + queue.isEmpty());  
        System.out.println("Queue size: " + queue.size());
        System.out.println("Dequeue: " + queue.dequeue()); 
        System.out.println("Dequeue: " + queue.dequeue());  
    }
}



