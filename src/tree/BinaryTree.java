package tree;

public class BinaryTree {
    class Node {
        Node left;
        Node right;
        int key;
        String value;
    }

    private Node root = null;

    public BinaryTree() { }

    public void insert(int key, String value) {
        Node new_node = new Node();
        new_node.left = null;
        new_node.right = null;
        new_node.key = key;
        new_node.value = value;

        if (root == null) {
            root = new_node;
            return;
        }
        Node traveler = root;
        while (traveler != null) {
            if (key <= traveler.key) {
                if (traveler.left == null) {
                    traveler.left = new_node;
                    return;
                }
                traveler = traveler.left;
            } else {
                if (traveler.right == null) {
                    traveler.right = new_node;
                    return;
                }
                traveler = traveler.right;
            }
        }
    }
    /*
    public boolean delete(int key) {
        if (root == null) {
            return false;
        }
        Node traveler = root;
        while (traveler != null) {
            if (key <= traveler.key) {
                if (traveler.left.key == key) {
                    
                }
                traveler = traveler.left;
            } else {
                traveler = traveler.right;
            }
        }
        return false;
    }
    */

    public String getString(int key) {
        //search for string based on key
        return "";
    }
}