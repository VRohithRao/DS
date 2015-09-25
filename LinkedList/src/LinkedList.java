
/*Java Linked List program to add an element to end of the list
 * or add an element to start of a list 
 * or add element at a specified index position
*/

public class LinkedList{
   private Node head;
   private int listSize = 0;
   
   public LinkedList() {
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
   
   public void addFirst(Object data){
       // add the node to fisrt of the list.
       Node temp = head.getNext();
       Node current = new Node(data, temp);
       head.setNext(current);
       listSize ++;
   }
   
   public void addAtIndex(Object data, int index){
       // add node at specified index.
       Node temp = head;
       Node current = new Node(data);
       int pos = 0;
       while(temp.getNext()!=null && pos < index){
               temp = temp.getNext();
               pos++;
       }
       current.setNext(temp.getNext());
       temp.setNext(current);
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
   
   private static class Node{
       private Object data;
       private Node next;
       
       public Node(Object _data){ 
       //constructor allows you to add nodes to specified index & last
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
       LinkedList list = new LinkedList();
       list.add(1);
       list.add(2);
       list.addFirst(4);
       list.add("a");
       list.add(2.3455);
       System.out.println("The List :" + list.display());
       list.addAtIndex(6, 0);
   }
}