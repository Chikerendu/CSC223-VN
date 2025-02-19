package csc223.vn;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree implements Tree{
    private TreeNode root;
    
    public BinaryTree() {
        this.root = null;
    }
    @Override
    public String levelorder() {
        if(root == null) {
            return "";
        }
        String result = "";
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode curr = queue.remove();
            result += curr.data;
            if(curr.left != null) {
                queue.add(curr.left);
            }
            if(curr.right != null) {
                queue.add(curr.right);
            }
        }
        return result;
    }
    @Override
    public String preorder() {
        return preorderHelper(root);
    }
    private String preorderHelper(TreeNode node) {
        if(node == null) {
            return "";
        }
        String result = "" + node.data;
        result += preorderHelper(node.left);
        result += preorderHelper(node.right);
        return result;
    }
    @Override
    public String inorder() {
        return inorderHelper(root);
    }
    private String inorderHelper(TreeNode node) {
        if(node == null) {
            return "";
        }
        String result = "";
        result += inorderHelper(node.left);
        result += node.data;
        result += inorderHelper(node.right);
        return result;
    }
    @Override
    public String postorder() {
        return postorderHelper(root);
    }
    private String postorderHelper(TreeNode node) {
        if(node == null) {
            return "";
        }
        String result = "";
        result += postorderHelper(node.left);
        result += postorderHelper(node.right);
        result += node.data;
        return result;
    }
    @Override
    public void insert(char item) {
        root = insertRecursive(root, item);
    }
    private TreeNode insertRecursive(TreeNode node, char item) {
        if (node == null) {
            return new TreeNode(item);  
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
    
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
    
            if (current.left == null) {
                current.left = new TreeNode(item);
                return node;  
            } else {
                queue.add(current.left);
            }
    
            if (current.right == null) {
                current.right = new TreeNode(item);
                return node; 
            } else {
                queue.add(current.right);
            }
        }
        return node;
    }
    public boolean search(char item) {
        return searchRecursive(root, item);
    }
    private boolean searchRecursive(TreeNode node, char item) {
        if(node == null) {
            return false;
        }
        if(node.data == item) {
            return true;
        }
        if(searchRecursive(node.left, item)) {
            return true;
        }
        if(searchRecursive(node.right, item)){
            return true;
        }
        return false;
    }
    @Override
    public int size() {
        return sizeHelper(root);
    }
    private int sizeHelper(TreeNode node) {
        if(node == null) {
            return 0;
        }
        return 1 + sizeHelper(node.left) + sizeHelper(node.right);
    }
    @Override
    public boolean isEmpty() {
        return root == null;
    }
    @Override
    public int height() {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int height = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            int i = 0;
            while(i < size) {
                TreeNode node = queue.remove();
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
                i = i + 1;
            }
            height = height + 1;
        }
        return height;
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.insert('A');
        tree.insert('B');
        tree.insert('C');
        tree.insert('D');
        tree.insert('E');

        System.out.println("Level Order: " + tree.levelorder());
        System.out.println("Preorder: " + tree.preorder());
        System.out.println("Inorder: " + tree.inorder());
        System.out.println("Postorder: " + tree.postorder());
        System.out.println("Size: " + tree.size());
        System.out.println("Height: " + tree.height());
        System.out.println("Search C: " + tree.search('C'));
        System.out.println("Search Z: " + tree.search('Z'));
        System.out.println("Is the tree empty? " + tree.isEmpty());
    }
}

