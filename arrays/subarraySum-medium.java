/*
Problem Statement:
Given an integer array nums and an integer k, return the total number 
of continuous subarrays whose sum equals k.

Approach:
- Use Prefix Sum with a HashMap.
- Maintain a running prefixSum while iterating through the array.
- If (prefixSum - k) exists in the map, it means a subarray with sum k exists.
- Store the frequency of prefix sums in the HashMap.
- Initialize map with (0,1) to handle subarrays starting from index 0.

Time Complexity:
O(n) → Single pass through the array.

Space Complexity:
O(n) → For storing prefix sums in HashMap.
*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);

        int prefixSum = 0;
        int count = 0;

        for(int i = 0; i < nums.length; i++)
        {
            prefixSum += nums[i];

            if(hm.containsKey(prefixSum - k))
                count = count + hm.get(prefixSum - k);

            if(hm.containsKey(prefixSum))
                hm.put(prefixSum, hm.get(prefixSum) + 1);
            else
                hm.put(prefixSum, 1);
        }

        return count;
    }
}
