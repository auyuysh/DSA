/*
Problem Statement: Implement a dynamic queue using an array that resizes when full, supporting enqueue, dequeue, and display operations.

Approach: Use an array that doubles in size when full. Copy elements to new array, reset front to 0. Enqueue and dequeue as in linear queue.

Time Complexity: Amortized O(1) for enqueue (due to occasional O(n) resize), O(1) for dequeue, O(n) for display.
*/
import java.util.Scanner;

class LinearQueue {
    int[] queue;
    int f, r;
    int size;

    LinearQueue(int capacity) {
        queue = new int[capacity];
        f = 0;
        r = -1;
        size = 0;
    }

    boolean empty() {
        return size == 0;
    }

    boolean isFull() {
        return size == queue.length;
    }

    public void enqueue(int x) {
        if (isFull()) {
            System.out.println("Queue is full, doubling the size");

            int newSize = queue.length * 2;
            int[] newArray = new int[newSize];

            // copy valid elements only
            for (int i = 0; i < size; i++) {
                newArray[i] = queue[f + i];
            }

            queue = newArray;
            f = 0;
            r = size - 1;
        }

        r++;
        queue[r] = x;
        size++;
    }

    public int dequeue() {
        if (empty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        int removed = queue[f];
        f++;
        size--;
        return removed;
    }

    public void display() {
        if (empty()) {
            System.out.println("Queue is empty");
            return;
        }

        for (int i = f; i <= r; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
}

public class Queue_dyanamicArray {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter the size of the queue");
        int capacity = in.nextInt();

        LinearQueue q = new LinearQueue(capacity);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.dequeue();
        q.enqueue(40);

        q.display();

        q.enqueue(50);
        q.enqueue(60);

        q.display();

        in.close();
    }
}
