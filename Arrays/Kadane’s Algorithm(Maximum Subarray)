/*
Problem: Maximum Subarray

Approach:
Use Kadane’s Algorithm to find the maximum subarray sum.

1. Traverse through the array while maintaining a running sum.
2. Update the maximum sum whenever the current sum becomes larger.
3. If the running sum becomes negative, reset it to zero
   because a negative sum cannot contribute to a larger subarray.
4. Track starting and ending indices of the maximum subarray.

Time Complexity: O(n)
Space Complexity: O(1)
*/
lass Solution {
    public int maxSubArray(int[] nums) {

       int sum = 0;
       int maxsum = Integer.MIN_VALUE;
       int tempstart = -1;
       int tempend = -1;
       int start = 0;
x6t
       for(int i = 0 ; i < nums.length ; i++)
       {
        sum += nums[i];
        if(sum == 0)
        {
           start = i;
        }
        if(sum > maxsum)
        {
            maxsum = sum;
            tempstart = start;
            tempend = i;
        }
        if(sum < 0)
        {
            sum = 0;
        }
       }
       return maxsum;
    }
}
