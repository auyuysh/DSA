/*
LEETCODE 2149
Problem: Rearrange Array Elements by Sign

Given an integer array nums containing equal numbers of positive and negative integers,
rearrange the array so that positive and negative numbers alternate, starting with a
positive number. The relative order of elements should be preserved.
*/


/*
Approach:

1. Create a result array of the same size.
2. Use two pointers: one for positive indices (0,2,4...) and one for negative indices (1,3,5...).
3. Traverse the input array and place positive numbers at posIndex and negative numbers at negIndex.
4. Increment the corresponding index by 2 each time.
*/


/*
Time Complexity: O(n)
Space Complexity: O(n)
*/


class Solution {
    public int[] rearrangeArray(int[] nums) {
        int posIndex = 0;
        int negIndex = 1;
        int result[] = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                result[posIndex] = nums[i];
                posIndex += 2;
            }
            else if(nums[i] < 0) {
                result[negIndex] = nums[i];
                negIndex += 2;
            }
        }

        return result;
    }
}
