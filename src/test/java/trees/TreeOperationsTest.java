package trees;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.lang.Integer;
import org.junit.Test;

public class TreeOperationsTest {
    int maxNodes;
    int maxDepth;
    ArrayList<Node<String>> treeList = new ArrayList<Node<String>>();;
    ArrayList<String> BFSexpects = new ArrayList<String>();

    public void automatedTestCaseGenerator() {
        maxNodes = (int) (Math.random() * 100) + 10;
        for (int i = 0; i < maxNodes; i++) {
            treeList.add(new Node<String>(Integer.toString(i + 1), null, null));
        }
        Collections.shuffle(treeList);

        /* builds the binary tree & the expected order for BFS */
        for (int i = 0; i < treeList.size(); i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            Node<String> parent = treeList.get(i);
            parent.left = left < treeList.size() ? treeList.get(left) : null;
            parent.right = right < treeList.size() ? treeList.get(right) : null;
            BFSexpects.add(parent.contents);
        }
    }

    @Test
    public void TestBreadthFirstSearchCorrectness() {
        automatedTestCaseGenerator();
        assertEquals(TreeOperations.bfs(treeList.get(0)), BFSexpects);
    }
}
