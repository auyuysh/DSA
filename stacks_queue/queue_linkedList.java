
import java.util.*;

class node{
    int val;
    node next;
    node(int data){
        this.val=data;
        next =null;
    }
}
class queue{
     static node left, right=null;
     static int size=0;
    static void enqueue(int x){
        node ele = new node(x);
        if(size==0)
        {
            left = ele;
            right = ele;
        }
        else{
            
            right.next = ele;
            right=ele;
        }
        size++;
        
    }
    static void dequeue(){
        if(isEmpty())
        return;
        else{
            left = left.next;
            size--;
        }
        if(size==0)
        {
            left=null;
            right=null;
        }
        
    }
    static boolean isEmpty(){
        if(size==0){
        System.out.println("the queue is empty");
        return true;
        }
        return false;
    }
    static void display(){
        if(isEmpty()){
        return;
        }
        else{
            node temp = left;
            while(temp!=null)
            {
                System.out.print(temp.val+"-->");
                temp=temp.next;
            }
            System.out.println();
        }
    }
}
public class queue_linkedList{
    public static void main(String args[])
    {
        queue q = new queue();
        //q.enqueue(1);
        //q.enqueue(2);
        //q.enqueue(3);
        q.display();
        q.dequeue();
        q.display();
    }
}
