import java.util.*;

/*
Problem:
Given a string s and an integer k, return the length of the longest substring 
that can be made of the same character after replacing at most k characters.

Approach:
Use sliding window + HashMap to store character frequencies.
Track the frequency of the most frequent character (maxfreq) in the window.
If (window size - maxfreq) > k, shrink the window from the left.
Otherwise, update the maximum length.

Time Complexity: O(n)  -> each character processed once
Space Complexity: O(1) -> at most 26 characters stored
*/

class Solution {
    public int characterReplacement(String s, int k) {
        
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0;
        int maxfeq = 0;
        int maxlen = 0;

        for(int right = 0; right < s.length(); right++){
            
            // add current character to map
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            // update max frequency in current window
            maxfeq = Math.max(maxfeq, map.get(s.charAt(right)));

            int windowSize = right - left + 1;

            // if replacements needed > k, shrink window
            if(windowSize - maxfeq > k){
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }

            // update max length
            maxlen = Math.max(maxlen, right - left + 1);
        }

        return maxlen;
    }
}
