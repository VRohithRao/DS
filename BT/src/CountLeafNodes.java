
public class CountLeafNodes {

	public static int countLeafs(BinaryTree.Node node){
		if(node == null)
			return 0;
		
		if (node.left == null && node.right == null)
			return 1;
		else
			return countLeafs(node.left) + countLeafs(node.right) ;
		
	}
	public static void main(String a[]){
		BinaryTree myTree = BinaryTree.createTree();
		System.out.print(countLeafs(myTree.root));
	}
}
