public class LLPairwiseSwap {
    private Node head;
    private int listSize = 0;
    
    public LLPairwiseSwap() {
        head = new Node(null);
    }
    
    public void add(Object data){
        // add the node to last of the list.
        Node temp = new Node(data);
        Node current = head;
        while(current.getNext() != null){
            current = current.getNext();
        }
        current.setNext(temp);
        listSize ++;
    }
    
    public String display(Node list){
        Node current = list.getNext();
        String finalList = "";
        while(current!=null){
            finalList += "[" + current.getData().toString() +"]";
            current = current.getNext();
        }
        return finalList;
    }

    public Node swapPairwise(){
        // add node at specified index.
        Node prev = null, first, second;
        Node current = head;
        Node temp = head;
        
        while(temp.getNext()!=null && temp.getNext().getNext()!=null){
            
            first = temp.getNext();
            second = temp.getNext().getNext();
            
            current = second;
            first.setNext(null);
            second.setNext(null);
            
            second.setNext(first);
            first.setNext(current);
            
            if(prev!=null)
            	prev.setNext(second);
            prev = current;
        }
        
        return prev;
    }   
   
    private static class Node{
	    private Object data;
	    private Node next;
	    
	    public Node(Object _data){ 
	        next = null;
	        data = _data;
	    }
	    public Node(Object _data, Node _next){
	        this.data = _data;
	        this.next = _next;
	    }
	    public Object getData(){
	        return data;
	    }
	    public void setData(Object _data){
	        data = _data;
	    }
	    public Node getNext(){
	        return next;
	    }
	    public void setNext(Node _next){
	        next = _next;
	    }
	   
	}
	
	
	public static void main(String arg[]){
		LLPairwiseSwap list = new LLPairwiseSwap();
	    list.add(1);
	    list.add(3);
	    list.add(5);
	    list.add(6);
	    list.add(7);
	    list.add(9);
	
	    System.out.println(list.display(list.head));
	    System.out.println(list.display(list.swapPairwise()));
	    
	    }
	}

