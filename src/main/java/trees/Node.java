package trees;

public class Node<A> {
    public A contents;
    public Node<A> left;
    public Node<A> right;

    public Node(A contents,
            Node<A> left,
            Node<A> right) {
        this.contents = contents;
        this.left = left;
        this.right = right;
    }
}
