import java.util.*;

class KthLargest {

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int k;

    // Constructor
    public KthLargest(int k, int[] nums) {
        this.k = k;

        // Build initial heap using your logic style
        for (int i = 0; i < nums.length; i++) {
            if (pq.size() < k) {
                pq.add(nums[i]);
            } else if (nums[i] > pq.peek()) {
                pq.poll();
                pq.add(nums[i]);
            }
        }
    }
    
    // Add new element (same as your add method idea)
    public int add(int val) {
        if (pq.size() < k) {
            pq.add(val);
        } 
        else if (val > pq.peek()) {
            pq.poll();
            pq.add(val);
        }

        return pq.peek();
    }
}
