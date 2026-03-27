import java.util.PriorityQueue;

/**
 * Problem: Merge k Sorted Linked Lists
 * -------------------------------------
 * Given an array of k linked lists, each sorted in ascending order, merge them into one
 * sorted linked list and return its head.
 *
 * Example:
 * Input: lists = [[1->4->5], [1->3->4], [2->6]]
 * Output: 1->1->2->3->4->4->5->6
 *
 * Approach:
 * 1. Use a min-heap (PriorityQueue) to always get the smallest node among the current heads.
 * 2. Push the head of each non-empty list into the heap.
 * 3. While the heap is not empty:
 *    a) Pop the smallest node from the heap.
 *    b) Attach it to the merged list.
 *    c) If this node has a next node, push the next node into the heap.
 * 4. Continue until all nodes are merged.
 *
 * Time Complexity: O(N log k)
 *   - N = total number of nodes across all lists
 *   - k = number of lists
 *   - Each node is added/polled from the heap → log k per operation.
 *
 * Space Complexity: O(k)
 *   - The heap stores at most one node from each list at any time.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        // Min-heap to store the current nodes, ordered by node value
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val)
        );

        // Add the head of each non-empty list into the heap
        for (ListNode node : lists) {
            if (node != null) pq.add(node);
        }

        // Dummy node to simplify list building
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // Extract the smallest node and push its next into the heap
        while (!pq.isEmpty()) {
            ListNode smallest = pq.poll();
            tail.next = smallest;
            tail = tail.next;

            if (smallest.next != null) {
                pq.add(smallest.next);
            }
        }

        return dummy.next;
    }
}
