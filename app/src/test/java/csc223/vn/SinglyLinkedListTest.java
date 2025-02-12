package csc223.vn;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SinglyLinkedListTest{
SinglyLinkedList list;

public void setUp() {
list = new SinglyLinkedList();
}

@Test
public void testInsertEmptyList() {
list.insert('A');
assertEquals(1, list.size());
assertEquals('A', list.getFirst());
}

@Test
public void testInsertTwoElements() {
list.insert('A');
list.insert('B');
assertEquals(2, list.size());
assertEquals('A', list.getFirst());
assertEquals('B', list.getLast());
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

@Test
public void testSize() {
assertEquals(0, list.size());
list.insert('A');
assertEquals(1, list.size());
}

@Test
public void testIsEmpty() {
assertTrue(list.isEmpty());
list.insert('A');
assertFalse(list.isEmpty());
}

@Test
public void testClear() {
list.insert('A');
list.insert('B');
list.clear();
assertEquals(0, list.size());
}

@Test
public void testContains() {
list.insert('A');
assertTrue(list.contains('A'));
assertFalse(list.contains('B'));
}

@Test
public void testIndexOf() {
list.insert('A');
list.insert('B');
assertEquals(0, list.indexOf('A'));
assertEquals(1, list.indexOf('B'));
}

@Test
public void testToString() {
list.insert('A');
list.insert('B');
assertEquals("AB", list.toString());
}
}