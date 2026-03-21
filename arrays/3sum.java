/*
Problem:
Given an integer array nums, return all unique triplets [nums[i], nums[j], nums[k]] 
such that i != j, i != k, j != k and:
    nums[i] + nums[j] + nums[k] == 0

The solution set must not contain duplicate triplets.

Approach:
- Sort the array
- Fix one element (i)
- Use two pointers (left, right) to find remaining two
- Skip duplicates at every step to avoid repeated triplets

Time: O(n^2)
Space: O(1) (excluding output)
*/

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(arr);

        for (int i = 0; i < n - 2; i++) {   // small optimization
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            int left = i + 1, right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == 0) {
                    ans.add(Arrays.asList(arr[i], arr[left], arr[right]));

                    left++;
                    right--;

                    while (left < right && arr[left] == arr[left - 1]) left++;
                    while (left < right && arr[right] == arr[right + 1]) right--;
                }
                else if (sum < 0) left++;
                else right--;
            }
        }

        return ans;
    }
}
