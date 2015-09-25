
public class MirrorOfBT {
	public static BinaryTree.Node mirrorBT(BinaryTree.Node node){
		if(node == null)
			return null;
		else
		{
			mirrorBT(node.left);
			mirrorBT(node.right);
			
			BinaryTree.Node temp = node.left;
			node.left = node.right;
			node.right = temp;
		}
		return node;
	}
	
	public static void main(String a[]){
		BinaryTree myTree = BinaryTree.createTree();
		myTree.inOrderRecursionHelper(myTree.root);
		System.out.println("");
		myTree.inOrderRecursionHelper(mirrorBT(myTree.root));
	}

}
