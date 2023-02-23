package avlTrees;

public class AVLTree {
    private class AVLNode {
        int value;
        int height;
        private AVLNode leftChild;
        private AVLNode rightChild;

        public AVLNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Value=" + this.value;
        }
    }

    private AVLNode root;

    public void getRoot() {
        System.out.println(root.value);
    }

    public void insertMine(int value) {
        insertMine(root, value);
    }

    public void insertMine(AVLNode root, int value) {
        if (root == null) {
            this.root = new AVLNode(value);
            return;
        }
        if (value < root.value) {
            if (root.leftChild == null) root.leftChild = new AVLNode(value);
            else insertMine(root.leftChild, value);
        } else {
            if (root.rightChild == null) root.rightChild = new AVLNode(value);
            else insertMine(root.rightChild, value);
        }
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private AVLNode insert(AVLNode root, int value) {
        // we go DOWN the tree and then RECURSIVELY GO BACK UP!
        if (root == null) {
            return new AVLNode(value);
        }

        if (value < root.value) root.leftChild = insert(root.leftChild, value);
        else root.rightChild = insert(root.rightChild, value);

        setHeight(root);
        return balance(root);
    }

    private int height(AVLNode node) {
        return (node == null) ? -1 : node.height;
    }

    private boolean isLeftHeavy(AVLNode node) {
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(AVLNode node) {
        return balanceFactor(node) < -1;
    }

    private int balanceFactor(AVLNode node) {
        return (node == null) ? 0 : height(node.leftChild) - height(node.rightChild);
    }

    private void balanceMine(AVLNode root) {
        if (balanceFactor(root.rightChild) > 0) {
            System.out.println("right rotate " + root.rightChild.value);
            System.out.println("left rotate " + root.value);
        }
        else if (balanceFactor(root.rightChild) < 0) {
            System.out.println("left rotate " + root.value);
        }

        if (balanceFactor(root.leftChild) > 0) {
            System.out.println("right rotate " + root.value);
        }
        else if (balanceFactor(root.leftChild) < 0) {
            System.out.println("left rotate " + root.leftChild.value);
            System.out.println("right rotate " + root.value);
        }
    }

    private AVLNode balance(AVLNode root) {
        if (isLeftHeavy(root)) {
            if (balanceFactor(root.leftChild) < 0) {
                root.leftChild = rotateLeft(root.leftChild);
            }
            return rotateRight(root);
        }
        if (isRightHeavy(root)) {
            if (balanceFactor(root.rightChild) > 0) {
                root.rightChild = rotateRight(root.rightChild);
            }
            return rotateLeft(root);
        }
        return root;
    }

    private AVLNode rotateLeft(AVLNode root) {
        var newRoot = root.rightChild;
        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private AVLNode rotateRight(AVLNode root) {
        var newRoot = root.leftChild;
        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private void setHeight(AVLNode node) {
        node.height = Math.max(
                height(node.leftChild),
                height(node.rightChild)) + 1;
    }

}
