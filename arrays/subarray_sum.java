/*
Problem:
Find the maximum sum of a contiguous subarray in a given array.

Approach:
Start from every index and keep adding elements to form subarrays.
Track the maximum sum encountered.

Time Complexity:
Brute Force: O(n^2)
Optimized (Kadane's Algorithm): O(n)

Space Complexity: O(1)
*/

class subarray_sum
{
    public static void main(String args[])
    {
        int arr[] = {-2, -3, -7, -2, -10, -4};
        int max = arr[0];
        int sum = 0;

        for(int i = 0; i < arr.length; i++)
        {
            for(int j = i; j < arr.length; j++)
            {
                sum = sum + arr[j];

                if(sum > max)
                    max = sum;
            }
            sum = 0;
        }

        System.out.println(max);
    }
}
