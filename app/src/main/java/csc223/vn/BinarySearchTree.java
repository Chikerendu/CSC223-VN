package csc223.vn;
public class BinarySearchTree {
public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    public TreeNode(int value) {
    this.value = value;
    this.left = null;
    this.right = null;
    }
    }
private TreeNode root;
    public BinarySearchTree() {
    this.root = null;
    }
public void insert(int value) {
    root = insertRecursive(root, value);
    }
private TreeNode insertRecursive(TreeNode node, int value) {
    if(node == null) {
    return new TreeNode(value);
    }
    if(value < node.value){
    node.left = insertRecursive(node.left, value);
    } else if(value > node.value) {
    node.right = insertRecursive(node.right, value);
    }
    return node;
    }
public void delete(int value) {
    root = deleteRecursive(root, value);
    }
private TreeNode deleteRecursive(TreeNode node, int value) {
    if(node == null) {
    return null;
    }
    if(value < node.value) {
    
    node.left = deleteRecursive(node.left, value);
    }
    else if(value > node.value) {
    node.right = deleteRecursive(node.right, value);
    }
    else {
    if(node.left == null && node.right == null) {
    return null;
    }
    if(node.left == null && node.right != null) {
    return node.right;
    }
    if(node.left != null && node.right == null) {
    return node.left;
    }
    TreeNode temp = getMinNodeRecursive(node.right);
    node.value = temp.value;
    node.right = deleteRecursive(node.right, temp.value);
    }
    return node;
    }
private TreeNode getMinNodeRecursive(TreeNode node) {
    if(node.left == null) {
    return node;
    } else {
    return getMinNodeRecursive(node.left);
    }
    }
public boolean search(int value) {
    return searchRecursive(root, value);
    }
private boolean searchRecursive(TreeNode node, int value) {
    if(node == null) {
    return false;
    }
    if(node.value == value) {
    return true;
    }
    if(value < node.value) {
    return searchRecursive(node.left, value);
    } else {
    return searchRecursive(node.right, value);
    
    }
    }
public void update(int oldValue, int newValue) {
    if(search(oldValue)) {
    delete(oldValue);
    insert(newValue);
    }
    }
public String inOrder() {
    String result = inOrderRecursive(root);
    result = result.trim();
    return result;
    }
private String inOrderRecursive(TreeNode node) {
    if(node == null) {
    return "";
    }
    String result = "";
    result += inOrderRecursive(node.left);
    result += node.value + " ";
    result += inOrderRecursive(node.right);
    return result;
    }
public TreeNode sortedArrayToBST(int[] values) {
    return sortedArrayToBSTRecursive(values, 0, values.length - 1);
    }
private TreeNode sortedArrayToBSTRecursive(int[] values, int start, int end) {
    if(start > end) {
    return null;
    }
    int mid = (start + end) / 2;
    TreeNode node = new TreeNode(values[mid]);
    node.left = sortedArrayToBSTRecursive(values, start, mid - 1);
    node.right = sortedArrayToBSTRecursive(values, mid + 1, end);
    return node;
    }
public int lowestCommonAncestor(int p, int q) {
    return lowestCommonAncestorRecursive(root, p, q);
    }
private int lowestCommonAncestorRecursive(TreeNode node, int p, int q) {
    if(node == null) {
    return -1;
    
    }
    if(p < node.value && q < node.value) {
    return lowestCommonAncestorRecursive(node.left, p, q);
    }
    if(p > node.value && q > node.value) {
    return lowestCommonAncestorRecursive(node.right, p, q);
    }
    return node.value;
    }
public static void main(String[] args) {
    BinarySearchTree bst = new BinarySearchTree();
    bst.insert(50);
    bst.insert(30);
    bst.insert(70);
    bst.insert(20);
    bst.insert(40);
    bst.insert(60);
    bst.insert(80);
    System.out.println("InOrder Traversal: " + bst.inOrder());
    System.out.println("Search 60: " + bst.search(60));
    System.out.println("Search 25: " + bst.search(25));
    bst.delete(70);
    System.out.println("After deleting 70: " + bst.inOrder());
    bst.update(60, 65);
    System.out.println("After update from 60 to 65: " + bst.inOrder());
    System.out.println("LCA of 20 & 40: " + bst.lowestCommonAncestor(20,40));
    }
    }