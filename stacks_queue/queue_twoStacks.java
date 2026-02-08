import java.util.Stack;
class queue{
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    void enqueue(int x)
    {
        s1.push(x);
        
    }
    void dequeue()
    {
        if(s1.isEmpty() && s2.isEmpty())
        {
            System.out.println("the queue is empty");
            return;
        }
        if(s2.isEmpty())
        {
            while(s1.isEmpty()!=true)
            {
                s2.push(s1.pop());
            }
           
        }
        System.out.println(s2.pop()+" removed");
        return;
        
    }
    void display(){
        if(s1.isEmpty() && s2.isEmpty())
        {
            System.out.println("the queue has nothing to display");
            return;
        }
        for (int i = s2.size() - 1; i >= 0; i--) {
            System.out.print(s2.get(i) + " ");
        }

    // Elements in s1 (rear part of queue)
        for (int i = 0; i < s1.size(); i++) {
            System.out.print(s1.get(i) + " ");
        }

        System.out.println();
    }
}
public class queue_twoStacks{
    public static void main(String args[])
    {
        queue q = new queue();
        q.display();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.display();
        q.dequeue();
        q.display();
        q.enqueue(4);
        q.enqueue(5);
        q.display();
    }
}
