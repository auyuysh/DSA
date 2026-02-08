class Stack{
    int capacity;
    int stack[];int size=0;
    Stack(int capacity){
        this.capacity=capacity;
        stack=new int[capacity];
    }
    void push(int x){
        if(size==stack.length)
        {
            System.out.println("the stack is full");
            return;
        }
        stack[size++]=x;
        
    }
    void pop()
    {
        if(isEmpty())
        {
            System.out.println("the stack is empty to pop");
            return;
        }
        System.out.println(stack[size-1]+"removed");
        size--;
    }
    boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }
    void display(){
        for(int  i=0;i<size;i++)
        {
            System.out.println(stack[i]+" ");
        }
    }
}
public class stack_array{
    public static void main(String args[])
    {
        Stack st = new Stack(3);
        st.push(1);
        st.push(2);
        st.push(3);
        st.display();
        st.pop();
        st.display();
    }
}
