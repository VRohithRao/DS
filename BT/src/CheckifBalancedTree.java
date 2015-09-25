public class CheckifBalancedTree {
	
	public static boolean isbalanced(BinaryTree.Node root){
		if(computeAndCheckHeight(root) == -1)
	          return false;
	    else
	    	return true;
	}
	
	public static int computeAndCheckHeight(BinaryTree.Node root){
	     /* Base case - Tree is empty */
	     if(root == null)
	          return 0;
	     /* Height of left subtree */
	     int leftSubTreeHeight = computeAndCheckHeight(root.left);
	     /* Left subtree is not balanced */
	     if(leftSubTreeHeight == -1)
	          return -1;  

	     /* Height of right subtree */
	     int rightSubTreeHeight = computeAndCheckHeight(root.right);
	     /* Right subtree is not balanced */
	     if(rightSubTreeHeight == -1)
	          return -1;

	     /* Difference in height */
	     int heightDifference = Math.abs(leftSubTreeHeight - rightSubTreeHeight);
	     /* Root node is not balanced */
	     if(heightDifference > 1)
	          return -1;
	     else
	          /* Height of the root node */
	          return Math.max(leftSubTreeHeight, rightSubTreeHeight) + 1;
	 }
	
	public static void main(String a[]){
		BinaryTree myTree = BinaryTree.createTree();
		System.out.print(isbalanced(myTree.root));
	}
	
}
