/**
 * Created by Rohith Vallu on 10/26/2015.
 */
public class LLSortedInsertion {
    private Node head;
    private int listSize = 0;

    public LLSortedInsertion() {
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

    public String display(){
        Node current = head.getNext();
        String finalList = "";
        while(current!=null){
            finalList += "[" + current.getData().toString() +"]";
            current = current.getNext();
        }
        return finalList;
    }

    public void addInSortedWay(int data){
        // add node at specified index.
        Node temp = head;
        Node current = new Node(data);
        int prev,next = 0;
        boolean addToEnd = true;
        while(temp.getNext()!=null){
            if(temp.getData() == null){
                temp = temp.getNext();
            }else{
                prev = ((Integer)temp.getData()).intValue();
                next = ((Integer)temp.getNext().getData()).intValue();
                if(data > prev && data > next && temp.getNext()!=null)
                    temp = temp.getNext();
                else if(data < prev && data < next){
                    current = head.next;
                    head = current;
                    addToEnd = false;
                    break;
                }
                else{
                    current.setNext(temp.getNext());
                    temp.setNext(current);
                    addToEnd = false;
                    break;
                }
            }
        }
        if(addToEnd){
            current.setNext(temp.getNext());
            temp.setNext(current);
        }
        listSize ++;
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
        LLSortedInsertion list = new LLSortedInsertion();
        list.add(1);
        list.add(3);
        list.add(5);
        list.addInSortedWay(6);
        list.addInSortedWay(2);
        list.addInSortedWay(5);
        list.addInSortedWay(5);

        System.out.println(list.display());
    }
}
