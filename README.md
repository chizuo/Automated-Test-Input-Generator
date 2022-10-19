# COMP587-Automated Test Input Generation
### Requirements
- Implement the methods for `class TreeOperations` in TreeOperations.java while using `class Node` in Node.java as the class definition of the vertices in the tree being evaluated by:
  - [x] `public static <A> ArrayList<A> bfs(Node<A> root)` : returns the items in the tree in a bfs lr order.
  - [x] `public static <A> ArrayList<A> preorder(Node<A> root)` : returns the items in the tree in a lr pre-order.
  - [x] `public static <A> int maxDepth(Node<A> root)` : return the maximum depth of the binary tree.
  - [X] `public static <A> int nodeCount(Node <A> root)` : return the number of nodes in a given tree.
- Write an automated test case generator for one of the four methods implemented in `class TreeOperations` in TreeOperationsTest.java
  - [X] Automated test case generator for `public static <A> ArrayList<A> bfs(Node<A> root)`
  - [X] Automated test case generator for `public static <A> ArrayList<A> preorder(Node<A> root)`
  - [X] Automated test case generator for `public static <A> int maxDepth(Node<A> root)`
  - [X] Automated test case generator for `public static <A> int nodeCount(Node <A> root)`
- Measures of effectiveness
  - [x] Achieve a minimum of 100% code coverage for the methods being tested by your automated test case generator.
  - [X] Achieve a minimum of 90% mutant kill rate for the methods being tested by your automated test case generator during mutation analysis.

![alt text](https://github.com/chizuo/COMP587-HW3/blob/main/Assignment3.gif)
 
![alt text](https://github.com/chizuo/COMP587-HW3/blob/main/coverage_mutation.gif)
