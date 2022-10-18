package trees;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import org.junit.Test;

public class TreeOperationsTest {
    Node<String> K = new Node<String>("K", null, null);
    Node<String> J = new Node<String>("J", null, K);
    Node<String> H = new Node<String>("H", null, null);
    Node<String> I = new Node<String>("I", H, J);
    Node<String> C = new Node<String>("C", null, null);
    Node<String> E = new Node<String>("E", null, null);
    Node<String> A = new Node<String>("A", null, null);
    Node<String> D = new Node<String>("D", C, E);
    Node<String> B = new Node<String>("B", A, D);
    Node<String> G = new Node<String>("G", null, I);
    Node<String> F = new Node<String>("F", B, G);

    @Test
    public void TestBreadthFirstSearchCorrectness() {
        ArrayList<String> expects = new ArrayList<String>();
        expects.add("F");
        expects.add("B");
        expects.add("G");
        expects.add("A");
        expects.add("D");
        expects.add("I");
        expects.add("C");
        expects.add("E");
        expects.add("H");
        expects.add("J");
        expects.add("K");
        var treeOperations = new TreeOperations();
        assertEquals(expects, TreeOperations.bfs(F));
        assertEquals(TreeOperations.bfs(F), treeOperations.bfs(F));
        assertEquals(TreeOperations.bfs(B), treeOperations.bfs(B));
        assertEquals(TreeOperations.bfs(G), treeOperations.bfs(G));
    }

    @Test
    public void TestPreOrderCorrectness() {
        ArrayList<String> expects = new ArrayList<String>();
        expects.add("F");
        expects.add("B");
        expects.add("A");
        expects.add("D");
        expects.add("C");
        expects.add("E");
        expects.add("G");
        expects.add("I");
        expects.add("H");
        expects.add("J");
        expects.add("K");
        assertEquals(expects, TreeOperations.preorder(F));
        var treeOperations = new TreeOperations();
        assertEquals(TreeOperations.preorder(F), treeOperations.preorder(F));
        assertEquals(TreeOperations.preorder(B), treeOperations.preorder(B));
        assertEquals(TreeOperations.preorder(G), treeOperations.preorder(G));
    }

    @Test
    public void TestMaxDepthCorrectness() {
        var treeOperations = new TreeOperations();
        assertEquals(TreeOperations.maxDepth(F), treeOperations.maxDepth(F));
        assertEquals(TreeOperations.maxDepth(B), TreeOperations.maxDepth(I));
        assertTrue(TreeOperations.maxDepth(G) > TreeOperations.maxDepth(B));
        assertTrue(TreeOperations.maxDepth(G) < TreeOperations.maxDepth(F));
        assertEquals(5, TreeOperations.maxDepth(F));
        assertEquals(3, TreeOperations.maxDepth(B));
        assertEquals(4, TreeOperations.maxDepth(G));
        assertEquals(2, TreeOperations.maxDepth(D));
    }
}
