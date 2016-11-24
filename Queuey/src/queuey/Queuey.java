package queuey;

import java.util.LinkedList;

public class Queuey<D> {
    
    LinkedList<D> queue;
    
    public Queuey (){
        queue = new LinkedList();
    }
    
    //Checking is our queue empty
    public boolean isEmpty () {
        return queue.isEmpty();
    }
    
    //What is the size of our queue
    public int size () {
        return queue.size();
    }
    
    public void enqueue(D n){
        queue.addLast(n);
    }

    public D dequeue() {
        return queue.remove(0);
    }
    
    //peak at firat item
    public D peek()
    {
        return queue.get(0);
    }    
    
    public static void main(String[] args) {
        Queuey numberQueue = new Queuey();
        numberQueue.enqueue(5);
        numberQueue.enqueue(7);
        numberQueue.enqueue(6);
        
        System.out.println("First out: " + numberQueue.dequeue());
        System.out.println("Peek @ 2nd item: " + numberQueue.peek());
        System.out.println("Second out: " + numberQueue.dequeue());
        System.out.println("Third out: " + numberQueue.dequeue());
    }
    
}
