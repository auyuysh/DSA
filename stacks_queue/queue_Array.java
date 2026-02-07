package stacks_queue;
import java.util.Scanner;
class linearQueue{
	int []queue;
	int f,r,capacity;
	
	linearQueue(int capacity){
		this.capacity=capacity;
		queue=new int[capacity];
		f=0;
		r=-1;
	}
	boolean empty() {
		if(r<f)
			return true;
		return false;
	}
	boolean isFull() {
		return r==queue.length-1;
	}
	public void enqueue(int x) {
		if(isFull()) {
			System.out.println("queue is full");
			return;
		}
		r++;
		queue[r]=x;
	}
	public int dequeue()
	{
		if(empty()) {
			System.out.println("queue is empty");
			return -1;
		}
		int removed = queue[r];
		r--;
		return removed;
	}
	public void display()
	{
		if(empty()) {
			System.out.println("queue is empty");
			return;
		}
		for(int i=0;i<=r;i++) {
			System.out.print(queue[i]+" ");
		}
		System.out.println();
	}
}
public class Queue_Array {
	public static void main(String args[])
	{
		Scanner in = new Scanner (System.in);
		System.out.println("Enter the size of the queue");
		int capacity = in.nextInt();
		linearQueue q = new linearQueue(capacity);
		q.enqueue(2);
		q.enqueue(6);
		q.enqueue(5);
		q.enqueue(4);
		q.enqueue(3);
		q.display();
		System.out.println(q.dequeue());
		q.display();
		q.enqueue(5);
		q.display();
	}
}
