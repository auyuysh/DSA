import java.util.*;

/*
Problem:
Given an array of integers A and an integer k, find the number of subarrays 
whose XOR is equal to k.

Approach:
Use prefix XOR technique with a HashMap.
- Maintain a running prefix XOR.
- If (prefixXor ^ k) exists in the map, it means a subarray with XOR = k exists.
- Store frequency of prefix XORs to count such subarrays efficiently.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public int countSubarrays(int[] A, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);

        int prefixXor = 0;
        int count = 0;

        for (int num : A) {
            prefixXor ^= num;

            int target = prefixXor ^ k;

            if (freq.containsKey(target)) {
                count += freq.get(target);
            }

            freq.put(prefixXor, freq.getOrDefault(prefixXor, 0) + 1);
        }
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] A = {4, 2, 2, 6, 4};
        int k = 6;
        Solution sol = new Solution();
        System.out.println(sol.countSubarrays(A, k));
    }
}
