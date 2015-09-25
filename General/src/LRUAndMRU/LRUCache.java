package LRUAndMRU;

import java.util.HashMap;

public class LRUCache {
    int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head=null;
    Node end=null;
 
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
 
    public int get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
 
        return -1;
    }
 
    public void remove(Node n){
        if(n.pre!=null){
            n.pre.next = n.next;
        }else{
            head = n.next;
        }
 
        if(n.next!=null){
            n.next.pre = n.pre;
        }else{
            end = n.pre;
        }
 
    }
 
    public void setHead(Node n){
        n.next = head;
        n.pre = null;
 
        if(head!=null)
            head.pre = n;
 
        head = n;
 
        if(end ==null)
            end = head;
    }
 
    public void set(int key, int value) {
        if(map.containsKey(key)){
            Node old = map.get(key);
            old.value = value;
            remove(old); 
            setHead(old);
        }else{
            Node created = new Node(key, value);
            if(map.size()>=capacity){
                map.remove(end.key);
                remove(end);
                setHead(created);
 
            }else{
                setHead(created);
            }    
 
            map.put(key, created);
        }
    }
    
    public static void main(String a[]){
    	LRUCache lru = new LRUCache(5);
    	lru.set(1,'A');
    	lru.set(2,'B');
    	lru.set(3,'C');
    	lru.set(4,'D');
    	lru.set(5,'E');
    	for(Integer i : lru.map.keySet())
    		System.out.println(lru.get(i));
    	
   	System.out.println(lru.map.size());
    	lru.set(6,'X');
    	for(Integer i : lru.map.keySet())
    		System.out.println(lru.get(i));
    	
    	lru.set(7,'Y');
    	
    	for(Integer i : lru.map.keySet())
    		System.out.println(lru.get(i));
    	
    }
}