package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeOperations {
    public static <A> ArrayList<A> bfs(Node<A> root) {
        var results = new ArrayList<A>();
        Queue<Node<A>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<A> next = queue.remove();
            if (next.left != null)
                queue.add(next.left);
            if (next.right != null)
                queue.add(next.right);
            results.add(next.contents);
        }
        return results;
    }

    public static <A> ArrayList<A> preorder(Node<A> root) {
        ArrayList<A> preOrder = new ArrayList<A>();
        Stack<Node<A>> stack = new Stack<Node<A>>();
        stack.push(root);
        while (!stack.empty()) {
            var node = stack.pop();
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
            preOrder.add(node.contents);
        }
        return preOrder;
    }

    public static <A> int maxDepth(Node<A> root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static <A> int nodeCount(Node<A> root) {
        ArrayList<A> preorderList = preorder(root);
        ArrayList<A> bfsList = bfs(root);
        int preOrderCount = preorderList.size();
        int bfsCount = bfsList.size();
        return preOrderCount == bfsCount ? bfsCount : -1;
    }
}
