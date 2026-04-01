class Solution {
    /*
    Problem Statement:
    Given a binary array nums (containing only 0s and 1s) and an integer k,
    return the maximum number of consecutive 1s in the array if you can flip
    at most k zeros to 1s.

    Approach (Sliding Window):
    - Use two pointers (left and right) to maintain a window.
    - Expand the window by moving the right pointer.
    - Count the number of zeros in the current window.
    - If the number of zeros exceeds k, shrink the window from the left
      until the number of zeros is at most k.
    - At each step, calculate the window size (right - left + 1)
      and update the maximum length.
    - This ensures we always maintain a valid window with at most k zero flips.

    Time Complexity:
    - O(n), where n is the length of the array.
    - Each element is visited at most twice (once by right pointer and once by left pointer).

    Space Complexity:
    - O(1), as we use only a few variables.
    */

    public int longestOnes(int[] nums, int k) {
        int left = 0; 
        int length = 0; 
        int count = 0; 
        int maxlen = 0;

        for(int right = 0; right < nums.length; right++) {
            if(nums[right] == 0) {
                count++;
            }

            if(count > k) {
                if(nums[left] == 0) {
                    count--;
                }
                left++;
            }

            maxlen = Math.max(maxlen, right - left + 1);
        }
        return maxlen;
    }
}
