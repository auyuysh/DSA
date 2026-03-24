import java.util.*;

/*
Problem:
Given an array of intervals where each interval is represented as [start, end],
merge all overlapping intervals and return a list of non-overlapping intervals
that cover all the intervals in the input.

Approach:
First, sort the intervals based on their start time.
Then iterate through each interval:
- If the current interval does not overlap with the last merged interval, add it to the result.
- If it overlaps, update the end of the last merged interval to the maximum of both ends.
This ensures all overlapping intervals are merged efficiently.

Time Complexity: O(n log n) due to sorting
Space Complexity: O(n) for storing merged intervals
*/

class Solution {
    public List<List<Integer>> merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<List<Integer>> merged = new ArrayList<>();

        for (int[] interval : intervals) {
            if (
                merged.isEmpty() ||
                merged.get(merged.size() - 1).get(1) < interval[0]
            ) {
                merged.add(Arrays.asList(interval[0], interval[1]));
            } else {
                int last = merged.size() - 1;
                int maxEnd = Math.max(
                    merged.get(last).get(1),
                    interval[1]
                );
                merged.get(last).set(1, maxEnd);
            }
        }

        return merged;
    }
}

class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] intervals = {
            {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };

        List<List<Integer>> result = sol.merge(intervals);

        for (List<Integer> interval : result) {
            System.out.print(
                "[" + interval.get(0) + "," + interval.get(1) + "] "
            );
        }
    }
}
