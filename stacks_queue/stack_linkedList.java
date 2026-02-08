class node{
    int val;
    node next;
    node(int x){
        this.val=x;
        this.next=null;
    }
}
class Stack{
    node head=null;node tail =null;
    int size=0;
    void push(int x)
    {
        node a = new node(x);
        if(size==0)
        {
            head=tail=a;
            size++;
            return;
        }
        tail.next =a;
        tail=a;
        size++;
    }
    void pop(){
        if(size ==0){
            System.out.println("nothing to pop");
            return;
        }
        node temp=head;
        while(temp.next.next!=null)
            temp=temp.next;
        temp.next = null;
        tail=temp;
    }
    void display(){
        if(size==0)
        {
            System.out.println("nothing to display");
            return;
        }
        node temp = head;
        while(temp!=null)
        {
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
        System.out.println();
    }
}
public class stack_linkedList{
    public static void main(String args[])
    {
        Stack st = new Stack();
        st.display();
        st.pop();
        st.push(1);
        st.push(2);
        st.push(3);
        st.display();
        st.pop();
        st.display();
    }
}
