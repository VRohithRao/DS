public class LLRemoveDupFromUnsortedList {
    private Node head;
    private Node secondHead;
    private int listSize = 0;

    public LLRemoveDupFromUnsortedList() {
        head = new Node(0);
        secondHead = new Node(0);
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

    public Node getMiddleNode(Node aNode) {

        Node slowPointer = aNode;
        Node fastPointer = aNode;

        while (fastPointer != null && fastPointer.getNext() != null && fastPointer.getNext().getNext() != null) {
            slowPointer = slowPointer.getNext();
            fastPointer = fastPointer.getNext().getNext();
        }
       
        return slowPointer;

    }


    public Node merge(Node first, Node second) {
        Node result = null;
        Node result_tail = null;
        Node next;
        while(first != null && second != null){
           if(first.data < second.data){
                next = first.next;
                first.next = null;
                if(result == null){
                    result = first;
                }else{
                    result_tail.next = first;
                }
                result_tail = first;
                first = next;
            }else{
                next = second.next;
                second.next = null;
                if(result == null){
                    result = second;
                }else{
                    result_tail.next = second;
                }
                result_tail = second;
                second = next;
            }
        }
        if(first != null){
            Node temp = result;
            while(temp.next != null){ temp = temp.next;}
            temp.next = first;
        }
        if(second != null){
            Node temp = result;
            while(temp.next != null){ temp = temp.next;}
            temp.next = second;
        }
        secondHead = result;
        return result;
    }

    public Node mergeSort(Node head) {
        if (head.getNext() == null)
            return head;

        Node first = head;
        Node mid = getMiddleNode(first);
        Node second = mid.getNext();
        mid.setNext(null);
        Node left = mergeSort(first);
        Node right = mergeSort(second);

        head = merge(left, right);
        return head;
    }

    public Node removeDuplicates(Node mainList) {

        Node current = mainList;
        while (current.getNext() != null) {
            if (current.getData() == current.getNext().getData()) {
                current.setNext(current.getNext().getNext());
            }
            if (current.getNext() != null)
                current = current.getNext();
        }
        return mainList;
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
        LLRemoveDupFromUnsortedList list = new LLRemoveDupFromUnsortedList();
        Node testNode = new Node(4);
        list.addToHead(testNode, 1);
        list.addToHead(testNode, 2);
        list.addToHead(testNode, 3);
        list.addToHead(testNode, 6);
        list.addToHead(testNode, 5);
      


        System.out.println(testNode);
        testNode = list.mergeSort(testNode);
        System.out.println(testNode);

    }
}

