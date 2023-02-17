import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import binaryTrees.BuildBinTree;

import static org.junit.jupiter.api.Assertions.*;

public class BuildBinTreeTest {

    @Test
    @DisplayName("Assert Root is First Added")
    void assertRootIsFirstAdded() {
        var tree = new BuildBinTree();
        tree.insert(5);
        assertTrue(tree.find(5));
    }
}
