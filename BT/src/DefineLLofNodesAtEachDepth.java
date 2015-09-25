import java.util.ArrayList;
import java.util.LinkedList;


public class DefineLLofNodesAtEachDepth {

	public static void llforNodes(BinaryTree.Node node){
		ArrayList<LinkedList<BinaryTree.Node>> result = new ArrayList<LinkedList<BinaryTree.Node>>();
		LinkedList<BinaryTree.Node> current = new LinkedList<BinaryTree.Node>();
		
		if(node!=null){
			current.add(node);
		}
		while(current.size() > 0){
			result.add(current);
			LinkedList<BinaryTree.Node> parents = current;
			current = new LinkedList<BinaryTree.Node>();
			for(BinaryTree.Node parent : parents){
				if(parent.left != null)
					current.add(parent.left);
				if(parent.right != null)
					current.add(parent.right);
			}
		}
		for(int i = 0 ; i < result.size(); i++){
			LinkedList<BinaryTree.Node> btNodes = result.get(i);
			System.out.println( " ");
			while(btNodes.size() > 0){
				BinaryTree.Node n = btNodes.remove();
				System.out.print( n.data + " ");
				
			}
		}
	}
	
	public static void main(String a[]){
		BinaryTree myTree = BinaryTree.createTree();
		llforNodes(myTree.root);
	}
}
