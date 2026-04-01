import java.util.*;

class Solution {

    /*
    Problem:
    Given an array of fruits, find the maximum number of fruits that can be collected
    in a continuous subarray containing at most 2 distinct types.

    Approach:
    - Use sliding window with two pointers (left, right).
    - Use HashMap to store count of fruits in current window.
    - Expand window by moving right pointer.
    - If distinct fruits > 2, shrink window from left.
    - Track maximum window size.

    Time Complexity: O(n)
    Space Complexity: O(1)
    */

    public int totalFruit(int[] fruits) {
        int left = 0;
        int maxlen = 0;

        Map<Integer, Integer> basket = new HashMap<>();

        for (int right = 0; right < fruits.length; right++) {

            // Add current fruit to map
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);

            // If more than 2 types, shrink window
            while (basket.size() > 2) {
                basket.put(fruits[left], basket.get(fruits[left]) - 1);

                // Remove fruit if count becomes 0
                if (basket.get(fruits[left]) == 0) {
                    basket.remove(fruits[left]);
                }

                left++; // Move left pointer
            }

            // Update maximum length
            maxlen = Math.max(maxlen, right - left + 1);
        }

        return maxlen;
    }
}
