/*
Problem:
Given an integer array nums and an integer target, return all unique quadruplets 
[nums[a], nums[b], nums[c], nums[d]] such that:
    nums[a] + nums[b] + nums[c] + nums[d] == target

The solution set must not contain duplicate quadruplets.

Approach:
1. Sort the array to make it easier to handle duplicates and apply two-pointer technique.
2. Fix the first element using index i.
3. Fix the second element using index j (after i).
4. Use two pointers (left = j+1, right = n-1) to find the remaining two elements.
5. Calculate the sum of four elements:
      sum = nums[i] + nums[j] + nums[left] + nums[right]
6. If sum == target → store the quadruplet and move both pointers.
7. If sum < target → move left pointer forward.
8. If sum > target → move right pointer backward.
9. Skip duplicates at every step (i, j, left, right) to ensure unique results.
10. Use long type for sum to avoid integer overflow.

Time Complexity:
O(n^3)
- First loop (i): O(n)
- Second loop (j): O(n)
- Two-pointer traversal: O(n)

Space Complexity:
O(1) extra space (excluding the output list)
*/

import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1, right = n - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] 
                             + nums[left] + nums[right];

                    if (sum == target) {
                        ans.add(Arrays.asList(
                            nums[i], nums[j], nums[left], nums[right]
                        ));

                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    }
                    else if (sum < target) left++;
                    else right--;
                }
            }
        }

        return ans;
    }
}
