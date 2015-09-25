
public class MaxHeightOfBT {
	public static int maxHeight(BinaryTree.Node root){
		if(root == null)
			return 0;
		return Math.max(maxHeight(root.left),maxHeight(root.right)) + 1;
	}
	
	public static void main(String a[]){
		BinaryTree myTree = BinaryTree.createTree();
		System.out.print(maxHeight(myTree.root));
	}
}
