import java.util.*;

/*
Problem:
Given an array nums and an integer goal, return the number of subarrays 
whose sum is equal to goal.

Approach:
Use prefix sum and a HashMap to store frequency of sums.
At each index, check if (currentSum - goal) exists in the map.
If it exists, add its frequency to the count (valid subarrays found).
Initialize map with (0 -> 1) to handle subarrays starting from index 0.

Time Complexity: O(n)  -> single pass through array
Space Complexity: O(n) -> storing prefix sums in map
*/

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        Map<Integer, Integer> prefixSumCount = new HashMap<>();

        int count = 0, sum = 0;

        prefixSumCount.put(0, 1);

        for (int num : nums) {
            sum += num;

            if (prefixSumCount.containsKey(sum - goal)) {
                count += prefixSumCount.get(sum - goal);
            }

            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
