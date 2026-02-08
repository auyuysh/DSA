import java.util.Scanner;

class LinearQueue {
    int[] queue;
    int front, rear, capacity;

    LinearQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
    }

    boolean isEmpty() {
        return front > rear;
    }

    boolean isFull() {
        return rear == capacity - 1;
    }

    void enqueue(int x) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        rear++;
        queue[rear] = x;
    }

    int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int removed = queue[front];
        front++;
        return removed;
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
}

public class Queue_Array {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the size of the queue:");
        int capacity = in.nextInt();

        LinearQueue q = new LinearQueue(capacity);

        q.enqueue(2);
        q.enqueue(6);
        q.enqueue(5);
        q.enqueue(4);
        q.enqueue(3);

        q.display();

        System.out.println("Dequeued: " + q.dequeue());
        q.display();

        q.enqueue(5);   // may show "Queue is full" due to linear queue limitation
        q.display();

        in.close();
    }
}
