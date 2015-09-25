import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
	
	public static void levelOrder(BinaryTree.Node node){
		Queue bstQ = new LinkedList<>();
		bstQ.add(node);
		System.out.println(node.data);
		while(bstQ.size() > 0){
			BinaryTree.Node current = (BinaryTree.Node) bstQ.remove();
			
			if(current.left != null){
				System.out.print(current.left.data + " : ");
				bstQ.add(current.left);
			}
			if(current.right != null){
				System.out.println(current.right.data);
				bstQ.add(current.right);
			}
			
			System.out.println("");
		}
		
	}
	
	public static void main(String a[]){
		BinaryTree myTree = BinaryTree.createTree();
		levelOrder(myTree.root);
	}
}
