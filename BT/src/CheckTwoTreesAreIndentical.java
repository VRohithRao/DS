
public class CheckTwoTreesAreIndentical {
	
	public static boolean areTressIdentical(BinaryTree.Node root, BinaryTree.Node root2){
		if(root == null && root2 == null)
			return true;
		
		if(root == null  || root2 == null)
			return false;
		
		if (root.data == root2.data){
			return areTressIdentical(root.left,root2.left) && areTressIdentical(root.right,root2.right);
		}
		else
			return false;
		
	}
	
	public static void main(String a[]){
		BinaryTree myTree = BinaryTree.createTree();
		BinaryTree myTree2 = BinaryTree.createTree2();
		System.out.print(areTressIdentical(myTree.root,myTree2.root));
	}
}
