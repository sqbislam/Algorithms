
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Saqib
 */

public class Deque<Item> implements Iterable<Item> {
    
    private Node front;
    private Node end;
    private int size;
    
    public Deque() {
    
    size=0;
    
    }                          // construct an empty deque
   
   public boolean isEmpty() {
         for ( Node n = front ; n!=null ; n = n.next ) {
           System.out.println( n.element );
       }
         
       return true;
   }                 // is the deque empty?
   
   
   public int size() {
       
   return -1;
   }      // return the number of items on the deque
   
   
   public void addFirst (Item item) {
       
       if(item == null) { 
           throw new IllegalArgumentException("Invalid null Input"); 
       }
       
       if( size == 0 ) {
       front = new Node(item,null);
       end = front;
       size++;
       }
       
       else{
        Node oldFirst = front;
        front = new Node(item , oldFirst);
        size++;
       }
   }         // add the item to the front
   
   
   public void addLast(Item item)    {
       
       if(item == null) { throw new IllegalArgumentException("Invalid null Input"); 
       } 
       
       
       if( size == 0 ) {
       end = new Node(item,null);
       front = end;
       size++;
       }
       
        else {
            
       Node oEnd = end;
       end = new Node(item , null);
       oEnd.next = end;
       size++;
       
        }
   }       // add the item to the end
   
   
   public Item removeFirst() {
        return null;
   } // remove and return the item from the front
   
   
   public Item removeLast() {
       Node n = new Node( null, null );
       Item removed=null;
       
        switch (size) {
            case 0:
                System.out.println("triggered");
                throw new NoSuchElementException("Queue is empty!");
            case 1:
                removed = ( Item ) end.element;
                end.next = null;
                end.element = null;
                size--;
                return removed;
            default:
                n=front;
                for (int i = 1 ; i < size-1 ; i++) {
                    n=n.next;
                }
                removed = ( Item ) end.element;
                end.element = null;   
                end=n;
                size--;
                return removed;
        }
       
   }  // remove and return the item from the end
   
   
   public Iterator<Item> iterator()       {
   
       return null;
   }  // return an iterator over items in order from front to end
   
   
   private class Node<Item>{
       Item element;
       Node next;
       
       private Node(Item e , Node n){
       element = e;
       next = n;
       }
       
}
   public static void main(String[] args){
   
   Deque d=new Deque();
   d.addLast("Hello");
   d.addLast("Okay");
   d.addLast("Bye");
   d.addLast("Why");
   d.addFirst("Hi");
   d.addFirst("Congrats");
   d.addLast("Great!");
   d.isEmpty();
   
       System.out.println(d.size);
       System.out.println(d.removeLast());
   
       System.out.println(d.size);
       System.out.println(d.removeLast());
   
       System.out.println(d.size);
       System.out.println(d.removeLast());
   
       System.out.println(d.size);
       System.out.println(d.removeLast());
   
       System.out.println(d.size);
       System.out.println(d.removeLast());
       
       System.out.println(d.size);
       System.out.println(d.removeLast());
   
       System.out.println(d.size);
       System.out.println(d.removeLast());
   
       System.out.println(d.size);
       System.out.println(d.removeLast());
   
       System.out.println(d.size);
       System.out.println(d.removeLast());
   
   
   
   }
   
}