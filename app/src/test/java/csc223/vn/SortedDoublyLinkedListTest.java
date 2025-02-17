package csc223.vn;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SortedDoublyLinkedListTest {
SortedLinkedList list;

public void setUp() {
list = new SortedLinkedList();
}

@Test
public void testInsertEmptyList() {
list.insert('A');
assertEquals(1, list.size());
assertEquals('A', list.getFirst());
assertEquals('A', list.getLast());
}

@Test
public void testInsertIntoSortedList() {
list.insert('B');
list.insert('A');
list.insert('C');
assertEquals(3, list.size());
assertEquals('A', list.getFirst());
assertEquals('C', list.getLast());
}

@Test
public void testSize() {
assertEquals(0, list.size());
list.insert('A');
assertEquals(1, list.size());
}

@Test
public void testRemoveFirstElement() {
list.insert('A');
list.insert('B');
list.remove('A');
assertEquals(1, list.size());
assertEquals('B', list.getFirst());
}

@Test
public void testRemoveLastElement() {
list.insert('A');
list.insert('B');
list.remove('B');
assertEquals(1, list.size());
assertEquals('A', list.getFirst());
}
}