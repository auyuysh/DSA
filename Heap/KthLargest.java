class Solution {
    /*
    Problem:
    Given an integer array nums and an integer k, return the kth largest element in the array.
    Note that it is the kth largest element in sorted order, not the kth distinct element.

    Approach:
    Use a min-heap of size k.
    1. Insert first k elements into the min-heap.
    2. For remaining elements:
       - If current element is greater than the heap top (smallest among k largest),
         remove the top and insert the current element.
    3. The root of the heap will be the kth largest element.

    Time Complexity: O(n log k)
    Space Complexity: O(k)
    */

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > pq.peek()) {
                pq.poll();
                pq.add(nums[i]);
            }
        }
        
        return pq.peek();
    }
}
