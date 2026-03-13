
/*
Problem Statement: Given an array nums of size n, return the majority element. The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Approach: Use a HashMap to count the frequency of each element. Iterate through the array, and for each element, increment its count. If the count exceeds n/2, return that element.

Time Complexity: O(n) for traversal, O(n) space for HashMap.
*/
import java.util.*;
class majorityElement{
    public static void main(String args[])
    {
         int nums []= {1, 1, 1, 2, 1, 2};
         HashMap<Integer,Integer> hm =new HashMap<>();
         for(int i =0;i<nums.length;i++)
         {
             hm.put(nums[i],0);
         }
         int n = nums.length/2;
         for(int i=0;i<nums.length;i++)
         {
             int counter = hm.get(nums[i])+1;
             if(counter > n)
             {
                 System.out.println(nums[i]);
                 break;
             }
             hm.put(nums[i],counter);
             
             
         }
    }
}
