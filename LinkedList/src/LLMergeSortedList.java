public class LLMergeSortedList {
    private Node head;
    private int listSize = 0;

    public LLMergeSortedList() {
        head = new Node(0);
    }

    public void add(int data) {
        // add the node to last of the list.
        Node temp = new Node(data);
        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(temp);
        listSize++;
    }

    public void addToHead(Node someNode, int data) {
        // add the node to last of the list.
        Node temp = new Node(data);
        Node current = someNode;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(temp);
        listSize++;
        System.out.println(listSize);

    }

    public Node sortedMerge(Node firstList, Node secondList){
        Node first, tail;
        first= tail = null;
        
    	while(firstList !=null && secondList !=null){
    		Node temp;
    		if(firstList.getData() < secondList.getData()){
    			temp = firstList.getNext();
    			firstList.setNext(null);
    			//useful piece of code to traverse a list.
                if(first == null)
                    first = firstList;
                else
                    tail.setNext(firstList);
                tail = firstList;
                // end here

    			firstList = temp;
    		}else{
    			temp = secondList.getNext();
    			secondList.setNext(null);
    			//useful piece of code to traverse a list.
                if(first == null)
                    first = secondList;
                else
                    tail.setNext(secondList);
                tail = secondList;
                // end here

    			secondList = temp;
    		}
    	}
    	if(secondList != null){
            tail.setNext(secondList);
            tail = secondList;
        }
    	if(firstList != null){
    		tail.setNext(firstList);
    		tail = firstList;
    	}
    	return first;
    }

    public String display(Node list) {
        Node current = list.getNext();
        String finalList = "";
        while (current != null) {
            finalList += "[" + current.getData() + "]";
            current = current.getNext();
        }
        return finalList;
    }

    private static class Node {

        private int data;
        private Node next;

        public Node(int _data) {
            next = null;
            data = _data;
        }


        @Override
        public String toString() {
            return data + " " + next;
        }

        public int getData() {
            return data;
        }

        public void setData(int _data) {
            data = _data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node _next) {
            next = _next;
        }
    }

    public static void main(String arg[]) {
    	LLMergeSortedList list = new LLMergeSortedList();
        Node testNode = new Node(5);
        list.addToHead(testNode, 10);
        list.addToHead(testNode, 15);
        
        
        Node testNode2 = new Node(2);
        list.addToHead(testNode2, 3);
        list.addToHead(testNode2, 20);
        

        System.out.println(testNode);
        
        System.out.print(list.sortedMerge(testNode, testNode2));
    }
}
