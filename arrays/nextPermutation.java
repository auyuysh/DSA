/*
LEETCODE PROBLEM 31.
Problem: Next Permutation

Given an integer array nums, rearrange it into the next lexicographically
greater permutation. If such a permutation is not possible, rearrange it
into the lowest possible order (ascending).

The rearrangement must be done in-place using constant extra memory.
*/


/*
Approach:

1. Traverse from right and find the first index where nums[i] < nums[i+1].
2. If no such index exists, reverse the whole array.
3. Otherwise, find the first element greater than nums[index] from the right and swap them.
4. Reverse the elements after index.
*/


/*
Time Complexity: O(n)
Space Complexity: O(1)
*/


class Solution {
    public void nextPermutation(int[] nums) {
        int index = -1;
        int n = nums.length;

        for(int i = n - 2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        if(index == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        for(int i = n - 1; i > index; i--) {
            if(nums[i] > nums[index]) {
                swap(nums, i, index);
                break;
            }
        }

        reverse(nums, index + 1, n - 1);
    }

    private void reverse(int[] arr, int start, int end) {
        while(start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
