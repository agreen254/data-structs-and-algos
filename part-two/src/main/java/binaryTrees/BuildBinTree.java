package binaryTrees;

public class BuildBinTree {
    // Tree (root)
    // Node (value, leftChild, rightChild)
    // insert(int value)
    // find(int value) : boolean

    // var current = root;
    // if insert value < root go left current = current.leftChild, else go right
    private class Node {
        private final int value;
        public Node leftChild;
        public Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        public boolean hasLeftChild() {
            return leftChild != null;
        }

        public boolean hasRightChild() {
            return rightChild != null;
        }
    }

    private Node root;
    public void insert(int insert_value) {
        if (root == null) {
            root = new Node(insert_value);
            return;
        }

        var current = root;
        while (true) {
            if (insert_value > current.value) {
                if (current.hasRightChild()) current = current.rightChild;
                else {
                    current.rightChild = new Node(insert_value);
                    break;
                }
            }
            else if (insert_value < current.value) {
                if (current.hasLeftChild()) current = current.leftChild;
                else {
                    current.leftChild = new Node(insert_value);
                    break;
                }
            }
        }
    }

    public boolean find(int query) {
        var current = root;
        while (current != null) {
            if (query > current.value) {
                if (current.hasRightChild()) current = current.rightChild;
                else break;
            }
            else if (query < current.value) {
                if (current.hasLeftChild()) current = current.leftChild;
                else break;
            }
            else return true;
        }
        return false;
    }

    public int minBinarySearch() {
        var current = root;
        int min = 0;

        while (current.leftChild != null) {
            current = current.leftChild;
            min = current.value;
        }
        return min;
    }

    public Node getRoot() {
        return this.root;
    }
}
