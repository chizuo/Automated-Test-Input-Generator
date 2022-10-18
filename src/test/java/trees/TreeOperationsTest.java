package trees;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.lang.Integer;
import org.junit.Test;
import org.junit.Before;

public class TreeOperationsTest {
    int maxNodes;
    int maxDepth = 1;
    ArrayList<Node<String>> treeList = new ArrayList<Node<String>>();;
    ArrayList<String> BFSexpects = new ArrayList<String>();
    ArrayList<String> PreOrderExpects = new ArrayList<String>();

    public void recursivePreOrder(Node<String> node) {
        if (node == null)
            return;
        PreOrderExpects.add(node.contents);
        recursivePreOrder(node.left);
        recursivePreOrder(node.right);
        return;
    }

    @Before
    public void automatedTestCaseGenerator() {
        maxNodes = (int) (Math.random() * 1000) + 10;
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

        /* calculates maxDepth of a full tree by dividing until it reaches root */
        for (int i = maxNodes; i > 1; maxDepth++) {
            i /= 2;
        }

        /* recursive preorder to get preorder list for TreeOperations preorder method */
        recursivePreOrder(treeList.get(0));
    }

    @Test
    public void TestBreadthFirstSearch() {
        assertEquals(TreeOperations.bfs(treeList.get(0)), BFSexpects);
    }

    @Test
    public void TestPreOrder() {
        assertEquals(new TreeOperations().preorder(treeList.get(0)), PreOrderExpects);
        assertEquals(TreeOperations.preorder(treeList.get(0)), PreOrderExpects);
    }

    @Test
    public void TestMaxDepth() {
        assertEquals(TreeOperations.maxDepth(treeList.get(0)), maxDepth);
    }

    @Test
    public void TestNodeCounter() {
        assertEquals(TreeOperations.nodeCount(treeList.get(0)), maxNodes);
    }
}
