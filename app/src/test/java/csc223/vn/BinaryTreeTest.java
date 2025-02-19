package csc223.vn;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {
    @Test
    public void testEmptyTree() {
        BinaryTree tree = new BinaryTree();
        assertTrue(tree.isEmpty());
        assertEquals(0, tree.size());
        assertEquals(0, tree.height());
        assertEquals("", tree.levelorder());
        assertEquals("", tree.preorder());
        assertEquals("", tree.inorder());
        assertEquals("", tree.postorder());
    }

    @Test
    public void testInsertOneElement() {
        BinaryTree tree = new BinaryTree();
        tree.insert('A');
        assertFalse(tree.isEmpty());
        assertEquals(1, tree.size());
        assertEquals(1, tree.height());
        assertEquals("A", tree.levelorder());
        assertEquals("A", tree.preorder());
        assertEquals("A", tree.inorder());
        assertEquals("A", tree.postorder());
    }

    @Test
    public void testInsertTwoElements() {
        BinaryTree tree = new BinaryTree();
        tree.insert('A');
        tree.insert('B');
        assertEquals(2, tree.size());
        assertEquals(2, tree.height());
        assertEquals("AB", tree.levelorder());
        assertEquals("AB", tree.preorder());
        assertEquals("BA", tree.inorder());
        assertEquals("BA", tree.postorder());
    }

    @Test
    public void testInsertThreeElements() {
        BinaryTree tree = new BinaryTree();
        tree.insert('A');
        tree.insert('B');
        tree.insert('C');
        assertEquals(3, tree.size());
        assertEquals(2, tree.height());
        assertEquals("ABC", tree.levelorder());
        assertEquals("ABC", tree.preorder());
        assertEquals("BAC", tree.inorder());
        assertEquals("BCA", tree.postorder());
    }

    @Test
    public void testSearch() {
        BinaryTree tree = new BinaryTree();
        tree.insert('A');
        tree.insert('B');
        tree.insert('C');
        assertTrue(tree.search('A'));
        assertTrue(tree.search('B'));
        assertTrue(tree.search('C'));
        assertFalse(tree.search('D'));
    }

    @Test
    public void testTreeSize() {
        BinaryTree tree = new BinaryTree();
        assertEquals(0, tree.size());
        tree.insert('A');
        assertEquals(1, tree.size());
        tree.insert('B');
        assertEquals(2, tree.size());
        tree.insert('C');
        assertEquals(3, tree.size());
    }

    @Test
    public void testTreeHeight() {
        BinaryTree tree = new BinaryTree();
        assertEquals(0, tree.height());
        tree.insert('A');
        assertEquals(1, tree.height());
        tree.insert('B');
        assertEquals(2, tree.height());
        tree.insert('C');
        assertEquals(2, tree.height());
    }
}