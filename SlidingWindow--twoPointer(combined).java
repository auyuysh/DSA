import java.util.*;

class Solution {
    /*
    Problem Statement:
    ------------------
    Given a string s, find the length of the longest substring
    without repeating characters.

    Approach (Sliding Window + HashMap):
    ------------------------------------
    - Use two pointers (l and r) to maintain a sliding window.
    - Use a HashMap to store the last occurrence index of each character.
    - Traverse the string with pointer r:
        1. If the current character is already seen AND lies within the current window,
           move the left pointer (l) to one position right of its last occurrence.
        2. Update the maximum length of the substring.
        3. Store/update the current character's index in the map.
    - Continue until the entire string is processed.

    Time Complexity:
    ----------------
    O(n) → Each character is processed at most once.

    Space Complexity:
    -----------------
    O(min(n, charset)) → For storing characters in HashMap.
    */

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int l = 0;      // left pointer
        int maxLen = 0;

        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);

            // If character is already in current window
            if (map.containsKey(ch) && map.get(ch) >= l) {
                l = map.get(ch) + 1;
            }

            // Update max length
            maxLen = Math.max(maxLen, r - l + 1);

            // Store/update last occurrence
            map.put(ch, r);
        }

        return maxLen;
    }
}
