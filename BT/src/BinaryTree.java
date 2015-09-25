import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author RamnathReddyMedikonda
 *
 */
public class BinaryTree {
	
	Node root;
	
	public BinaryTree() {
		// TODO Auto-generated constructor stub
		root = null;
	}
	
	public class Node {
		int data;
		Node left;
		Node right;
		
		public Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	/***********************************************
	 * 
	 * 					TRAVERSALS
	 * 
	 **********************************************/
	
	public void inOrderRecursion() {
		inOrderRecursionHelper(root);
	}
	
	public void inOrderRecursionHelper(Node currentNode) {
		if (currentNode != null) {
			inOrderRecursionHelper(currentNode.left);
			System.out.print(currentNode.data + "   ");
			inOrderRecursionHelper(currentNode.right);
		}
	}
	
	public void inOrderNoRecursion() {
		inOrderNoRecursionHelper(root);
	}
	
	public void inOrderNoRecursionHelper(Node currentNode) {
		Stack<Node> myStack = new Stack<Node>();
		
		while(currentNode != null || !myStack.isEmpty()) {
			if (currentNode != null) {
				myStack.add(currentNode);
				currentNode = currentNode.left;
			}
			else {
				currentNode = myStack.pop();
				System.out.print(currentNode.data + "   ");
				currentNode = currentNode.right;
			}
		}
	}
	
	public void preOrderRecursion() {
		preOrderRecursionHelper(root);
	}
	
	public void preOrderRecursionHelper(Node currentNode) {
		if (currentNode != null) {
			System.out.print(currentNode.data + "   ");
			preOrderRecursionHelper(currentNode.left);
			preOrderRecursionHelper(currentNode.right);
		}
	}
	
	public void preOrderNoRecursion() {
		preOrderNoRecursionHelper(root);
	}
	
	public void preOrderNoRecursionHelper(Node currentNode) {
		Stack<Node> myStack = new Stack<Node>();
		
		while (currentNode != null || !myStack.isEmpty()) {
			if (currentNode != null) {
				System.out.print(currentNode.data + "   ");
				myStack.add(currentNode.right);
				currentNode = currentNode.left;
			}
			else
				currentNode = myStack.pop();
		}
	}
	
	public void postOrderRecursion() {
		postOrderRecursionHelper(root);
	}
	
	public void postOrderRecursionHelper(Node currentNode) {
		if (currentNode != null) {
			postOrderRecursionHelper(currentNode.left);
			postOrderRecursionHelper(currentNode.right);
			System.out.print(currentNode.data + "   ");
		}
	}
	
	public void postOrderNoRecursion() {
		postOrderNoRecursionHelper(root);
	}
	
	public void postOrderNoRecursionHelper(Node currentNode) {
//		LinkedList<Node> myStack = new LinkedList<Node>();
//		if (currentNode == null)
//			return;
//		myStack.push(currentNode);
//		
//		while (!myStack.isEmpty()) {
//			currentNode = myStack.peek();
//			if (currentNode.left == null && currentNode.right == null) {
//				myStack.pop();
//				System.out.print(currentNode.data + "   ");
//			}
//			else {
//				if (currentNode.left != null)
//					myStack.push(currentNode.left);
//				if (currentNode.right != null)
//					myStack.push(currentNode.right);
//			}
//		}
		
		Stack<Node> myStack = new Stack();
		if(currentNode.right != null){
			myStack.push(currentNode.right);
		}
		
		while(!myStack.isEmpty()){
			myStack.push(currentNode);
			currentNode = currentNode.left;
			
			if(currentNode.right!=null){
				myStack.push(currentNode.right);
				myStack.push(currentNode);
			}
			
		}
	}
	
	
	public void printNodesLevel() {
		if (root == null)
			return;
		Queue<Node> myQueue = new LinkedList<Node>();
		myQueue.add(root);
		int nodesInCurrentLevel = 1;
		int nodesInNextLevel = 0;
		
		while (!myQueue.isEmpty()) {
			Node currentNode = myQueue.poll();
			nodesInCurrentLevel--;

			if (currentNode != null) {
				System.out.print(currentNode.data + "   ");
				myQueue.add(currentNode.left);
				myQueue.add(currentNode.right);
				nodesInNextLevel += 2;
			}
			if (nodesInCurrentLevel == 0) {
				System.out.println();
				nodesInCurrentLevel = nodesInNextLevel;
				nodesInNextLevel = 0;
			}
		}
	}
	
	public static BinaryTree createTree(){
		BinaryTree myTree = new BinaryTree();
//		myTree.root = myTree.new Node(5, null, null);
//		myTree.root.left = myTree.new Node(10, null, null);
//		myTree.root.right = myTree.new Node(15, null, null);
//		myTree.root.left.left = myTree.new Node(20, null, null);
//		myTree.root.left.right = myTree.new Node(25, null, null);
//		myTree.root.right.left = myTree.new Node(30, null, null);
//		myTree.root.right.right = myTree.new Node(35, null, null);
//		myTree.root.right.left.right = myTree.new Node(40, null, null);
//		myTree.root.left.right.left = myTree.new Node(45, null, null);
//		myTree.root.left.right.left.left = myTree.new Node(50, null, null);
		
		myTree.root = myTree.new Node(8, null, null);
		myTree.root.left = myTree.new Node(4, null, null);
		myTree.root.right = myTree.new Node(3, null, null);
		myTree.root.left.left = myTree.new Node(3, null, null);
		myTree.root.left.right = myTree.new Node(5, null, null);
		
		
		return myTree;
	}
	
	public static BinaryTree createTree2(){
		BinaryTree myTree = new BinaryTree();
		myTree.root = myTree.new Node(5, null, null);
		myTree.root.left = myTree.new Node(10, null, null);
		myTree.root.right = myTree.new Node(15, null, null);
		myTree.root.left.left = myTree.new Node(20, null, null);
		myTree.root.left.right = myTree.new Node(25, null, null);
		myTree.root.right.left = myTree.new Node(30, null, null);
		myTree.root.right.right = myTree.new Node(35, null, null);
		myTree.root.right.left.right = myTree.new Node(40, null, null);
		myTree.root.left.right.left = myTree.new Node(45, null, null);
//		myTree.root.left.right.left.left = myTree.new Node(60, null, null);
		
		return myTree;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinaryTree myTree = createTree();
		System.out.println("*** Printing Nodes in each Level ***");
		myTree.printNodesLevel();
		System.out.println("*** Inorder Recursive Traversal ***");
		myTree.inOrderRecursion();
		System.out.println();
		System.out.println("*** Inorder Non Recursive Traversal ***");
		myTree.inOrderNoRecursion();
		System.out.println();
		System.out.println("*** Preorder Recursive Traversal ***");
		myTree.preOrderRecursion();
		System.out.println();
		System.out.println("*** Preorder Non Recursive Traversal ***");
		myTree.preOrderNoRecursion();
		System.out.println();
		System.out.println("*** Postorder Recursive Traversal ***");
		myTree.postOrderRecursion();
		System.out.println();
		System.out.println("*** Postorder Non Recursive Traversal ***");
		myTree.postOrderNoRecursion();
		
		
		//myTree.postOrderNoRecursion();
	}

	

}
