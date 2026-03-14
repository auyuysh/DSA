/*
Problem:
Find the maximum profit from a single buy and sell of stock.
You must buy before selling. If no profit is possible, return 0.

Approach:
Track the minimum price seen so far (buy day).
For each price, calculate profit = current price - min price.
Update maximum profit if it increases.

Time Complexity:
Brute Force: O(n^2)  -> check every pair of days
Optimized:   O(n)    -> single pass through the array
Space:       O(1)
*/

class buySell {
    public static void main(String args[]) {

        int arr[] = {9,8,7,6,5,4};

        int diff = 0;
        int i = 0;
        int j = 1;

        while(j < arr.length)
        {
            if(arr[j] < arr[i])
            {
                i = j;
            }

            if(arr[j] - arr[i] > diff)
            {
                diff = arr[j] - arr[i];
            }

            j++;
        }

        System.out.println(diff);
    }
}
