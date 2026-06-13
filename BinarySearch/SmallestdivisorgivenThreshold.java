/*
LeetCode 1283 - Find the Smallest Divisor Given a Threshold

Approach:
- The divisor can range from 1 to the maximum element in the array.
- Apply Binary Search on this search space.
- For each divisor (mid), calculate:
      ceil(nums[i] / mid)
  for all elements and find their total sum.
- If the sum is less than or equal to the threshold,
  try finding a smaller valid divisor.
- Otherwise, increase the divisor.

Why Binary Search?
- As the divisor increases, the total sum decreases.
- This forms a monotonic search space:
      Smaller divisor -> Larger sum
      Larger divisor  -> Smaller sum

Time Complexity:
- O(n * log(max(nums)))
  where n = number of elements.

Space Complexity:
- O(1)

Example:
nums = [1,2,5,9], threshold = 6

Divisor = 5
Sum = ceil(1/5) + ceil(2/5) + ceil(5/5) + ceil(9/5)
    = 1 + 1 + 1 + 2
    = 5 <= 6

Try smaller divisors until the smallest valid divisor is found.
*/


class Solution {
    public static int FindMax(int[] nums)
    {
        int max = 0;
        for(int i = 0 ; i < nums.length ; i++)
        {
            if(nums[i] > max)
            {
                max = nums[i];
            }
        }
        return max;
    }
    public static boolean resultlesserthanthreshold(int[] nums , int mid , int threshold)
    {
        long sum = 0;
        for(int i = 0 ; i < nums.length ; i++)
        {
            long addingup = 0;
            if(mid != 0)
            {
                addingup =(long) (nums[i] + mid - 1) / mid;
            }
            else
            {
                addingup = 0;
            }
            sum = sum + addingup;
        }
        if(sum <= (long)threshold)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public int smallestDivisor(int[] nums, int threshold) {

        int low = 1;
        int high = FindMax(nums);

        while(low <= high)
        {
            int mid = low + (high - low) / 2;

            if(resultlesserthanthreshold(nums , mid , threshold))
            {
                high  = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }

        return low;
        
    }
}
