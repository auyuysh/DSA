/*
Problem Statement:
Given a k-sorted array (an array where each element is at most k positions away 
from its correct sorted position), sort the array efficiently.

Approach (Min Heap):
1. In a k-sorted array, the smallest element for any index i will be present 
   within the next (k+1) elements.
2. Use a Min Heap (PriorityQueue) of size (k+1).
3. Insert the first (k+1) elements into the heap.
4. For the remaining elements:
   - Extract the minimum element from the heap and place it in the array.
   - Add the next element from the array into the heap.
5. After processing all elements, extract the remaining elements from the heap 
   and place them into the array.

Time Complexity:
- Building heap of size k: O(k)
- For n elements, each insertion and deletion takes O(log k)
- Total: O(n log k)

Space Complexity:
- O(k) for the heap
*/

import java.util.*;

class Solution {
    public int[] sortKSortedArray(int[] arr, int k) {
        int n = arr.length;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int index = 0;

        // Add first k+1 elements to heap
        for (int i = 0; i < Math.min(n, k + 1); i++) {
            minHeap.add(arr[i]);
        }

        // Process remaining elements
        for (int i = k + 1; i < n; i++) {
            arr[index++] = minHeap.poll();
            minHeap.add(arr[i]);
        }

        // Extract remaining elements from heap
        while (!minHeap.isEmpty()) {
            arr[index++] = minHeap.poll();
        }

        return arr;
    }
}
