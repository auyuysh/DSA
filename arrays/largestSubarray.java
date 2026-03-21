/*
Problem:
Find the length of the longest subarray with sum = k.

Approach:
- Use prefix sum + HashMap
- Store first occurrence of each prefix sum
- If (currSum == k) → update max length
- If (currSum - k) seen before → subarray exists
- Do NOT overwrite existing prefix sum (keep first index)

Time: O(n)
Space: O(n)
*/

import java.util.*;

class longestSubarray {
    int subarray(int nums[], int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int currSum = 0, maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];

            if (currSum == k)
                maxLen = i + 1;

            if (hm.containsKey(currSum - k)) {
                int len = i - hm.get(currSum - k);
                maxLen = Math.max(maxLen, len);
            }

            // store only first occurrence
            if (!hm.containsKey(currSum))
                hm.put(currSum, i);
        }

        return maxLen;
    }

    public static void main(String args[]) {
        longestSubarray ob = new longestSubarray();

        int nums[] = {1, -1, 5, -2, 3};
        int k = 3;

        System.out.println("Longest length: " + ob.subarray(nums, k));
    }
}
