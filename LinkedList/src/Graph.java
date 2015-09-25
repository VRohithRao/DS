import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Graph {
	
	static class Node {
		private String data;
		private int dist;
		private int inDegree;
		List<Node> adjacenctNode = new LinkedList<Node>();

		public void addAdjNode(Node Child){
		    adjacenctNode.add(Child);
		    Child.inDegree++;

		}

		public Node(String string) {
		    this.data = string;
		}

		public int getInDegree() {
		    return inDegree;
		}

		public void setInDegree(int inDegree) {
		    this.inDegree = inDegree;
		}

		@Override
		public String toString() {
		    return ""+  data ;
		}
		}
	
	static class Edge{
		private int distance;
		private Node src;
		private Node dest;
		public Edge(int dist, Node src, Node dest) {
		    this.distance = dist;
		    this.src = src;
		    this.dest = dest;
		    src.addAdjNode(dest);
		}
		}
private int vertices;
private Set<Node> nodes = new HashSet<Node>();
private Set<Edge> edges = new HashSet<Edge>();
public Graph (int vertices) {
    this.vertices = vertices;
}
public void addVertex(Node node){
    this.nodes.add(node);
}
public void addNodes (Set<Node> nodeList) {
    this.nodes =  nodeList;
}
public void addEdge(Edge eg ){
    this.edges.add(eg);
}
public  Set  topologicalSort() {
    Queue<Node> q = new LinkedList<Node>();
    Set<Node> topoSort = new LinkedHashSet<Node>();
    int vertexProcessesCtr = 0;
    for(Node m : this.nodes){
        addToQueueToposort(m,topoSort,vertexProcessesCtr,q);
    }
    while(!q.isEmpty()) {
        Node m = q.poll();
        for(Node child : m.adjacenctNode){
            int indeq = child.getInDegree()-1;
            child.setInDegree(indeq);
            addToQueueToposort(child,topoSort,vertexProcessesCtr,q);
        }
    }
    
    if(vertexProcessesCtr > this.vertices) {
        System.out.println();
    }
    
    for (Node n : topoSort) {
    	System.out.println(n.data);
    }
    return topoSort;
}
private void addToQueueToposort(Node node, Set topoSort, int vertexProcessesCtr, Queue<Node> q) {
    if(node.getInDegree()==0){
        q.add(node);
        ++vertexProcessesCtr;
        topoSort.add(node);
    }
}

public static void main(String args[]) {
	Node TEN = new Node("10");
	Node ELEVEN = new Node("11");
    Node TWO = new Node("2");
    Node THREE = new Node("3");
    Node FIVE = new Node("5");
    Node SEVEN = new Node("7");
    Node EIGHT = new Node("8");
    Node NINE = new Node("9");
    
    SEVEN.addAdjNode(ELEVEN);
    
    SEVEN.addAdjNode(EIGHT);
    
    FIVE.addAdjNode(ELEVEN);
    
    THREE.addAdjNode(EIGHT);
    
    THREE.addAdjNode(TEN);
    
    ELEVEN.addAdjNode(TEN);
    
    ELEVEN.addAdjNode(TWO);
    
    ELEVEN.addAdjNode(NINE);
        
    EIGHT.addAdjNode(NINE);
        
    
    
    Graph g = new Graph(6);
    g.nodes.add(TWO);
    g.nodes.add(THREE);
    g.nodes.add(FIVE);
    g.nodes.add(SEVEN);
    g.nodes.add(TEN);
    g.nodes.add(ELEVEN);
    g.nodes.add(EIGHT);
    g.nodes.add(NINE);
    
    
    g.topologicalSort();
}

}