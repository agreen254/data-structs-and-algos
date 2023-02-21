import binaryTrees.BinTreeSolution;
import avlTrees.AVLTree;

import java.util.ArrayList;

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
        System.out.println("Is Equal");
        var treeTwo = new BinTreeSolution();
        treeTwo.insert(7);
        treeTwo.insert(4);
        treeTwo.insert(9);
        treeTwo.insert(1);
        treeTwo.insert(6);
        treeTwo.insert(8);
        treeTwo.insert(10);
        System.out.println(tree.equals(treeTwo));
        System.out.println("Validating a Binary Tree");
        System.out.println("Test with the swapRoot Method");
        System.out.println(tree.validateMine());
        System.out.println(tree.isBinarySearchTree());
        System.out.println("Nodes at Distance K");
        tree.distanceK(2);
        tree.distanceK(1);
        tree.distanceK(0);
        var list = tree.getNodesAtDistance(1);
        for (var item : list) System.out.println("Array List Item: " + item);
        System.out.println("Level-Order Traverse");
        tree.traverseLevelOrder();
        System.out.println("Binary Search");
        int[] arr = { 1, 3, 5, 7, 9, 11, 13 };
        var searcher = new BinSearch();
        System.out.println(searcher.search(arr, 9));
        System.out.println(searcher.searchRecurse(arr, 3, 0, arr.length -1));
        System.out.println(searcher.searchRecurse(arr, 2, 0, arr.length -1));

        // System.out.println("Multi-Thread");
        // int numTrials = 3;
        // for (int i = 0; i < numTrials; i++) {
        //     var thread = new MultiThread(i + 1);
        //     Thread myThread = new Thread(thread);
        //     myThread.start();  // must invoke start() method to multi-thread. invoking run() will not.
        // }

        System.out.println("Binary Tree Size");
        var data = new ArrayList<Integer>();
        tree.size(data);
        System.out.println(data.size());

        System.out.println("Count Leaves");
        System.out.println(tree.countLeaves());

        System.out.println("Binary Tree Max Value");
        System.out.println(tree.max());

        System.out.println("Binary Tree Contains");
        System.out.println(tree.contains(7));

        System.out.println("Is Sibling");
        System.out.println(tree.isSibling(4, 9));

        System.out.println("Get Ancestors");
        System.out.println(tree.getAncestors(6));

        System.out.println("AVL Trees");
        var avl = new AVLTree();
        avl.insertMine(7);
        avl.insertMine(4);
        avl.insertMine(9);
        avl.insertMine(1);
        avl.insertMine(6);
        avl.insertMine(8);
        avl.insertMine(10);
        var avlS = new AVLTree();
        avlS.insert(10);
        avlS.insert(30);
        avlS.insert(20);
    }
}