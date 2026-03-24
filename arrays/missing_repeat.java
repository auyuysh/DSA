import java.util.*;

/*
Problem:
Given an array of size n containing numbers from 1 to n, one number is missing
and one number is repeating. Find both the repeating and the missing numbers.

Approach:
First, sort the array. Then:
1. Traverse the array to find the repeating number by checking if any two
   consecutive elements are equal.
2. Traverse again to find the missing number by checking the mismatch between
   the expected value (i + 1) and the actual value at index i.

Time Complexity: O(n log n) due to sorting
Space Complexity: O(1) (in-place sorting, ignoring recursion stack)
*/

class Solution {
    public int[] findMissingRepeatingNumbers(int[] nums) {
        Arrays.sort(nums);

        int repeating = -1, missing = -1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                repeating = nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                missing = i + 1;
                break;
            }
        }

        return new int[]{repeating, missing};
    }
}

public class Main {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 5, 4, 6, 7, 5};

        Solution sol = new Solution();
        int[] result = sol.findMissingRepeatingNumbers(nums);

        System.out.printf("The repeating and missing numbers are: {%d, %d}\n", result[0], result[1]);
    }
}
