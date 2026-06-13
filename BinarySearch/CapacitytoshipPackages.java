/*
LeetCode 1011 - Capacity To Ship Packages Within D Days

Approach:
- The minimum ship capacity must be at least the heaviest package.
- The maximum ship capacity can be the sum of all package weights.
- Apply Binary Search on this capacity range.

For each capacity (mid):
- Simulate loading packages in order.
- If adding a package exceeds the current capacity,
  start a new day.
- Count the number of days required.

Decision:
- If requiredDays <= givenDays,
  this capacity works, so try a smaller capacity.
- Otherwise, increase the capacity.

Why Binary Search?
- Larger ship capacity -> Fewer days needed.
- Smaller ship capacity -> More days needed.
- This creates a monotonic search space.

Example:
weights = [1,2,3,4,5,6,7,8,9,10]
days = 5

Capacity = 15

Day 1: 1+2+3+4+5 = 15
Day 2: 6+7 = 13
Day 3: 8
Day 4: 9
Day 5: 10

Required days = 5

Time Complexity:
O(n * log(sum(weights)))

Space Complexity:
O(1)
*/

class Solution {
    public static int FindTotalWeightsofPackages(int[] weights)
    {
        int maxweight = 0;
        for(int i = 0 ; i < weights.length ; i++)
        {
            maxweight = maxweight + weights[i];
        }
        return maxweight;
    }
    public static int findlow(int[] weights)
    {
        int max = 0;
        for(int num : weights)
        {
            if(num > max)
            {
                max = num;
            }
        }
        return max;
    }
    public static int Minshipcapacity(int[] weights , int mid , int days)
    {
        int sum = 0;
        int d = 1; 
        
        for(int i = 0 ; i < weights.length ; i++)
        {
            if(sum + weights[i] > mid)
            {
                d = d + 1;         
                sum = weights[i]; 
            }
            else
            {
                sum = sum + weights[i]; 
            }
        
    }
      return d;
    }
    public static int shipWithinDays(int[] weights, int days) {

        int low = findlow(weights);
        int high = FindTotalWeightsofPackages(weights);

        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            int requireddays = Minshipcapacity(weights , mid , days);

            if(requireddays <= days)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return low;
        
    }
}
