import java.util.Scanner;

class CircularQueue {
    int[] queue;
    int f, r, capacity;
    int size = 0;

    CircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        f = -1;
        r = -1;
    }

    boolean empty() {
        return size == 0;
    }

    boolean isFull() {
        return f == (r + 1) % queue.length;
    }

    public void enqueue(int x) {
        if (isFull()) {
            System.out.println("queue is full");
            return;
        }

        if (f == -1) {
            f = 0;
            r = 0;
        } else {
            r = (r + 1) % queue.length;
        }

        queue[r] = x;
        size++;
    }

    public int dequeue() {
        if (empty()) {
            System.out.println("queue is empty");
            return -1;
        }

        int removed = queue[f];

        if (f == r) {
            f = -1;
            r = -1;
        } else {
            f = (f + 1) % queue.length;
        }

        size--;
        return removed;
    }

    public void display() {
        if (empty()) {
            System.out.println("queue is empty");
            return;
        }

        int i = f;
        while (true) {
            System.out.print(queue[i] + " ");
            if (i == r)
                break;
            i = (i + 1) % capacity;
        }
        System.out.println();
    }
}

public class circular_queue {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the size of the queue");
        int capacity = in.nextInt();

        CircularQueue q = new CircularQueue(capacity);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.display();

        q.dequeue();
        q.dequeue();

        q.enqueue(50);
        q.enqueue(60);
        q.display();
    }
}
