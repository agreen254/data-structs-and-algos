package binaryTrees;

import java.util.ArrayList;

public class BinTreeSolution {
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) { this.value = value; }

        @Override
        public String toString() {
            return "Node=" + value;
        }
    }

    private Node root;

    public void insert(int value) {
        var node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }

        var current = root;

        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            }
            else {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean find(int value) {
        var current = root;
        while (current != null) {
            if (value < current.value) current = current.leftChild;
            else if (value > current.value) current = current.rightChild;
            else return true;
        }
        return false;
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }
    private void traversePreOrder(Node root) {
        // root (print)
        // left children
        // right children
        // when we visit the left or right children we recursively call the method
        if (root == null) return;  // OUR BASE CONDITION: without it we would throw a NullPointerException

        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root) {
        if (root == null) return;

        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root) {
        if (root == null) return;

        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null) return -1;

        if (root.leftChild == null && root.rightChild == null) return 0;  // if we're at a leaf node

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    public int min() {
        return min(root);
    }

    // O(n)
    private int min(Node root) {
        // the implementation is more simple for a binary search tree
        // because you just go to the leftmost node
        if (isLeaf(root)) return root.value;

        var left = min(root.leftChild);
        var right = min(root.rightChild);
        return Math.min(Math.min(left, right), root.value);
    }

    // O(log n)
    public int minBinarySearch() {
        if (root == null) throw new IllegalStateException();

        var current = root;
        var last = current;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last.value;
    }

    public boolean isEqualMine() {
        return isEqualMine(root, root);
    }

    private boolean isEqualMine(Node nodeOne, Node nodeTwo) {
        if ((isLeaf(nodeOne) && !isLeaf(nodeTwo)) || (!isLeaf(nodeOne) && isLeaf(nodeTwo))) {
            return false;
        }

        return ((nodeOne.value == nodeTwo.value) && (nodeOne.leftChild.value == nodeTwo.leftChild.value) && (nodeOne.rightChild.value == nodeTwo.rightChild.value));
    }

    private boolean isLeaf(Node node) {
        return node.leftChild == null && node.rightChild == null;
    }

    public boolean equals(BinTreeSolution other) {
        if (other == null) return false;
        return equals(root, other.root);
        // method has access to the private field root because its in the class!!!
    }

    private boolean equals(Node first, Node second) {
        if (first == null && second == null) return true;
        if (first != null && second != null) {
            return first.value == second.value
                    && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, second.rightChild);
        }
        return false;
    }

    public boolean validateMine() {
        return validateMine(root, -100_000, 100_000);
    }

    private boolean validateMine(Node node, int min, int max) {
        // I think it worked ??!!
        if (node == null) return true;

        return (node.value > min) && (node.value < max)
                && validateMine(node.leftChild, min, node.value)
                && validateMine(node.rightChild, node.value, max);
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node root, int min, int max) {
        if (root == null) return true;

        if (root.value < min || root.value > max) return false;

        return isBinarySearchTree(root.leftChild, min, root.value - 1)
                && isBinarySearchTree(root.rightChild, root.value + 1, max);

    }

    public void swapRoot() {
        var temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }

    public void distanceK(int distance) {
        distanceK(root, distance);
    }

    private void distanceK(Node root, int distance) {
        // this one worked too!!
        if (root == null) return;
        if (distance == 0) System.out.println(root.value);
        distance -= 1;
        distanceK(root.leftChild, distance);
        distanceK(root.rightChild, distance);
    }

    public ArrayList<Integer> getNodesAtDistance(int distance) {
        var list = new ArrayList<Integer>();
        getNodesAtDistance(root, distance, list);
        return list;
    }

    private void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list) {
        if (root == null) return;
        if (distance == 0) {
            list.add(root.value);
            return;
        }

        getNodesAtDistance(root.leftChild, distance - 1, list);
        getNodesAtDistance(root.rightChild, distance - 1, list);
    }

    public void traverseLevelOrder() {
        for (var i = 0; i <= height(); i++) {
            for (var value : getNodesAtDistance(i)) System.out.println(value);
        }
    }

}
