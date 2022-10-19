package trees;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.lang.Integer;
import org.junit.Test;
import org.junit.Before;

public class TreeOperationsTest {
    int maxNodes = (int) (Math.random() * 1000) + 10;
    int maxDepth = 1;
    ArrayList<String> uniqueContent = new ArrayList<String>();
    ArrayList<Node<String>> treeList = new ArrayList<Node<String>>();
    ArrayList<String> BFSexpects = new ArrayList<String>();
    ArrayList<String> PreOrderExpects = new ArrayList<String>();
    Node<String> root;

    @Before
    public void automatedContentGenerator() {
        for (int i = 0; i < maxNodes; i++) {
            uniqueContent.add(Integer.toString(i + 1));
            treeList.add(new Node<String>(Integer.toString(i + 1), null, null));
        }
        Collections.shuffle(uniqueContent);
        Collections.shuffle(treeList);
    }

    @Before
    public void automatedTestCaseGeneratorMaxDepth() {
        /* Calculates max depth by doing a level order traversal btt until root level */
        for (int i = maxNodes; i > 1; maxDepth++) {
            i /= 2;
        }
    }

    @Before
    public void automatedTestCaseGeneratorBFS() {
        /* builds the binary tree & the expected order for BFS traversal */
        for (int i = 0; i < treeList.size(); i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            Node<String> parent = treeList.get(i);
            parent.left = left < treeList.size() ? treeList.get(left) : null;
            parent.right = right < treeList.size() ? treeList.get(right) : null;
            BFSexpects.add(parent.contents);
        }
    }

    public void automatedTestCaseGeneratorPreOrder() {
        /* builds the binary tree & expected order for pre-order traversal */
        root = recursiveTreeBuilder(0);
    }

    public Node<String> recursiveTreeBuilder(int depth) {
        if (uniqueContent.size() == 0 || depth == maxDepth)
            return null;
        String content = uniqueContent.get(0);
        uniqueContent.remove(0);
        PreOrderExpects.add(content);
        Node<String> node = new Node<String>(content, recursiveTreeBuilder(depth + 1),
                recursiveTreeBuilder(depth + 1));
        return node;
    }

    @Test
    public void TestBreadthFirstSearch() {
        assertEquals(TreeOperations.bfs(treeList.get(0)), BFSexpects);
    }

    @Test
    public void TestPreOrder() {
        automatedTestCaseGeneratorPreOrder();
        assertEquals(PreOrderExpects, TreeOperations.preorder(root));
        assertEquals(PreOrderExpects, new TreeOperations().preorder(root));
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