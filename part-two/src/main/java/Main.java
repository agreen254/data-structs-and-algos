import binaryTrees.BuildBinTree;
import binaryTrees.BinTreeSolution;

public class Main {
    public static void main(String[] args) {
        System.out.println("Binary Tree Stuff");
        // var tree = new binaryTrees.BuildBinTree();
        var tree = new BinTreeSolution();
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);
        // System.out.println(tree.find(3));
        System.out.println("Pre-Order Traversal");
        tree.traversePreOrder();
        System.out.println("In-Order Traversal");
        tree.traverseInOrder();
        System.out.println("Post-Order Traversal");
        tree.traversePostOrder();
        System.out.println("Tree Height");
        System.out.println(tree.height());
        System.out.println("Tree Min");
        System.out.println(tree.min());
        System.out.println(tree.minBinarySearch());
    }
}