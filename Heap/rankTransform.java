import java.util.*;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        
        int n = arr.length;
        
        // Step 1: Copy array
        int[] temp = arr.clone();
        
        // Step 2: Sort the copy
        Arrays.sort(temp);
        
        // Step 3: Assign ranks using HashMap
        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(temp[i])) {
                map.put(temp[i], rank++);
            }
        }
        
        // Step 4: Replace values in original array
        for (int i = 0; i < n; i++) {
            arr[i] = map.get(arr[i]);
        }
        
        return arr;
    }
}
