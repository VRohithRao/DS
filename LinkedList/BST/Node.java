/**
 * Represents a node in the Binary Search Tree.
 */
public class Node<T> {
  //The value present in the node.
  public int value;

  //The reference to the left subtree.
  public Node left;

  //The reference to the right subtree.
  public Node right;

  public Node(int value) {
    this.value = value;
  }

}
