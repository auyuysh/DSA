/*
Problem Statement:
Given an integer array nums, find the element that appears more than ⌊n/2⌋ times.
If no such element exists, return -1.

Approach (Moore’s Voting Algorithm + Verification):
- Step 1: Use Moore’s Voting Algorithm to find a candidate.
  - Maintain a candidate and a count.
  - If count becomes 0, choose current element as candidate.
  - If element equals candidate, increment count.
  - Else decrement count.
- Step 2: Verify the candidate by counting its occurrences.
  - If it appears more than n/2 times, return it.
  - Else return -1.

Time Complexity:
O(n) → One pass for finding candidate + one pass for verification.

Space Complexity:
O(1) → Constant extra space.
*/

class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        // Step 1: Find candidate
        for(int num : nums) {
            if(count == 0) {
                candidate = num;
            }

            if(num == candidate) count++;
            else count--;
        }

        // Step 2: Verify candidate
        count = 0;
        for(int num : nums) {
            if(num == candidate) count++;
        }

        if(count > nums.length / 2) return candidate;
        else return -1;
    }
}
