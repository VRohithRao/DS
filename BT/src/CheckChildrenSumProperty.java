
public class CheckChildrenSumProperty {
	public static boolean isSumOfChildEquRoot(BinaryTree.Node node){
		int left_data = 0, right_data = 0; int flag = 0;
		if(node == null || (node.left == null && node.right == null))
			return true;
		else{
			if(node.left != null)
			    left_data = node.left.data;
			 
			    /* If right child is not present then 0 is used
			      as data of right child */
			    if(node.right != null)
			       right_data = node.right.data;
			 
			    /* if the node and both of its children satisfy the
			       property return 1 else 0*/
			    if((node.data == left_data + right_data))
			      return true;
			    else{
			    	isSumOfChildEquRoot(node.left);
		    		isSumOfChildEquRoot(node.right);
			    }
			  return false;
		}
			
	}
	
	
	public static void main(String a[]){
		BinaryTree myTree = BinaryTree.createTree();
		System.out.print(isSumOfChildEquRoot(myTree.root));
	}

}
