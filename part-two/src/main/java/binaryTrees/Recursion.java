package binaryTrees;

public class Recursion {
    public int factorialIteration(int n) {
        var factorial = 1;
        for (var i = n; i > 1; i--) factorial *= i;
        return factorial;
    }

    // f(3)
    //   3 * f(2)
    //         2 * f(1)
    //               1 * f(0)
    public int factorialRecurs(int n) {
        // BASE CONDITION
        // A WAY TO TERMINATE THE RECURSION
        if (n == 0) return 1;

        return n * factorialRecurs(n - 1);
        // Java uses a stack for managing recursive function calls!
    }
}
