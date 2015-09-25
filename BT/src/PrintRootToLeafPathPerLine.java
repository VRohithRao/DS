
public class PrintRootToLeafPathPerLine {
	
	public static void printPath(BinaryTree.Node node, int[] path,int pathlen){
		if(node != null){
			path[pathlen] = node.data;
			pathlen++;
		}
		if(node == null)
			return;
		if(node.left == null && node.right == null){
			for(int i = 0; i < pathlen; i++)
				System.out.print(path[i]);
				System.out.println("");
		}else{
			printPath(node.left, path, pathlen);
			printPath(node.right, path, pathlen);
			
		}
		
	}
	
	public static void main(String a[]){
		BinaryTree myTree = BinaryTree.createTree();
		int arr[] = new int[100];
		printPath(myTree.root, arr, 0);
	}
}
