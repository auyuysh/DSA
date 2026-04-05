class Solution {

    /*
    Problem:
    Given a string num representing a large integer, return the largest-valued odd integer 
    (as a string) that is a non-empty substring of num. If no odd integer exists, return "".

    Approach:
    Traverse the string from right to left and find the first odd digit.
    The largest-valued substring will be the prefix ending at that index,
    because longer prefixes represent larger numbers.

    Time Complexity:
    O(n), where n is the length of the string. We scan the string once.
    */

    public String largestOddNumber(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            if ((s.charAt(i) - '0') % 2 == 1) {
                return s.substring(0, i + 1);
            }
        }
        return "";
    }
}
