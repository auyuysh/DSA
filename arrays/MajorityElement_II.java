/*
Problem Statement:
Given an integer array nums, return all elements that appear more than ⌊n/3⌋ times.

Approach (Extended Moore’s Voting Algorithm):
- There can be at most 2 elements appearing more than n/3 times.
- Maintain two candidates and their counts.
- First pass:
  - Find potential candidates using voting logic.
- Second pass:
  - Count occurrences of candidates to verify.

Time Complexity:
O(n) → Two passes through the array.

Space Complexity:
O(1) → Constant extra space.
*/

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0;
        int candidate1 = 0, candidate2 = 0;

        // Step 1: Find candidates
        for(int num : nums) {
            if(num == candidate1) count1++;
            else if(num == candidate2) count2++;
            else if(count1 == 0) {
                candidate1 = num;
                count1 = 1;
            }
            else if(count2 == 0) {
                candidate2 = num;
                count2 = 1;
            }
            else {
                count1--;
                count2--;
            }
        }

        // Step 2: Verify candidates
        count1 = 0;
        count2 = 0;

        for(int num : nums) {
            if(num == candidate1) count1++;
            else if(num == candidate2) count2++;
        }

        List<Integer> result = new ArrayList<>();

        if(count1 > nums.length / 3) result.add(candidate1);
        if(count2 > nums.length / 3) result.add(candidate2);

        return result;
    }
}
