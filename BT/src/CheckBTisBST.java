import java.util.LinkedList;
import java.util.Queue;



public class CheckBTisBST {
	public static void checkifBST(BinaryTree.Node node){
		int flag = 0;
		if(node == null){
			return;
		}
		Queue<BinaryTree.Node> st = new LinkedList<BinaryTree.Node>();
		st.add(node);
		while(st.size() > 0){
			BinaryTree.Node n = st.remove();
			if((n.left != null && n.data > n.left.data) &&
				(n.right != null && n.data < n.right.data)){
				st.add(n.left);
				st.add(n.right);
			}else if(n.left == null && (n.right != null && n.data < n.right.data)){
				st.add(n.right);
			}else if(n.right == null && (n.left != null && n.data > n.right.data)){
				st.add(n.left);
			}else if(n.left == null && n.right == null){
				flag = 0;
			}else{
				flag = 1;
			}
				
				
			if(flag == 1){
				System.out.print("Not a BST");
				break;
			}
				
		}
		if(flag == 0)
			System.out.print("Its a BST");
	}
	public static int index = 0;
	
	public static void checkBSTArray(BinaryTree.Node node, int arr[]){
		if(node == null)
			return;
		checkBSTArray(node.left, arr);
		arr[index] = node.data;
		index++;
		checkBSTArray(node.right, arr);
		
	}
	
	public static void main(String a[]){
		BinaryTree myTree = BinaryTree.createTree();
		checkifBST(myTree.root);
		int arr[] = new int[10];
		checkBSTArray(myTree.root,arr);
		int flag = 0;
		for(int k = 1; k<arr.length;k++){
			if(arr[k-1] > arr[k]){
				flag = 1;
			}
		}
		if(flag == 1)
			System.out.println("Not BST");
			
	}
}
