/**
 * PROBLEM: Painter's Partition Problem
 * 
 * PROBLEM DESCRIPTION:
 * Given an array 'arr[]' where each element represents the length of a wall board, 
 * and 'k' painters. A single painter takes 1 unit of time to paint 1 unit of board. 
 * The task is to find the MINIMUM TIME required to paint all the boards under these constraints:
 *   1. A board cannot be partitioned among multiple painters.
 *   2. A painter can only paint contiguous sections of boards.
 * 
 * APPROACH: Binary Search on Answer (Search Space Approach)
 *   - Search Space: 'low' is the maximum single board (since a painter must paint at least that),
 *     and 'high' is the sum of all boards (if only 1 painter paints everything).
 *   - We use binary search to pick a 'mid' value (hypothetical max time allowed for a painter).
 *   - A helper function checks if 'k' painters can finish the job within 'mid' time.
 *   - If possible (true), we try for an even smaller optimal time by shrinking 'high'.
 *   - If not possible (false), it means 'mid' time is too small, so we increase 'low'.
 * 
 * COMPLEXITY ANALYSIS (TCSC):
 * ---------------------------------------------------------------------------------------
 * | Complexity | Notation                       | Explanation                           |
 * ---------------------------------------------------------------------------------------
 * | Time       | O(N * log(Sum - Max))          | Binary search runs log(Sum-Max) times.|
 * |            |                                | Each step loops N times inside helper.|
 * ---------------------------------------------------------------------------------------
 * | Space      | O(1)                           | Constant space. No extra data         |
 * |            |                                | structures are allocated.             |
 * ---------------------------------------------------------------------------------------
 */

class Solution {

    /**
     * Helper Function: PaintersPaintWall
     * Greedily checks if it is possible to allocate boards to 'k' painters
     * such that no painter works for more than 'mid' units of time.
     * 
     * Time Complexity (Helper): O(N) - single pass through the array.
     * Space Complexity (Helper): O(1) - only primitive variables used.
     */
    public static boolean PaintersPaintWall(int[] arr , int mid , int k)
    {
        int total = 0; // Tracks current painter's workload
        int d = 1;     // Tracks count of painters utilized (starts with 1st painter)
        
        for(int i = 0 ; i < arr.length ; i++)
        {
            // If adding current board exceeds the maximum limit 'mid'
            if(total + arr[i] > mid)
            {
                d = d + 1; // Allocate a new painter
                total = 0; // Reset workload for the new painter
            }
            total = total + arr[i]; // Add board to current painter's workload
        }
        
        // If total painters needed is within or equal to available painters 'k'
        if(d <= k)
        {
            return true; // Configuration is feasible
        }
        else
        {
            return false; // Configuration is NOT feasible
        }
    }

    /**
     * Main Function: minTime
     * Finds the absolute minimum time required to paint all boards using 'k' painters.
     * 
     * Overall Time Complexity: O(N * log(Sum - Max))
     * Overall Space Complexity: O(1)
     */
    public int minTime(int[] arr, int k) {
        
        int low = 0;  // Represents the lower bound of search space (Max element)
        int high = 0; // Represents the upper bound of search space (Sum of all elements)
        
        // Step 1: Initialize the search space bounds
        for(int num : arr)
        {
            low = Math.max(low , num); // A single board cannot be split, so max element is the floor
            high += num;               // If 1 painter does all work, time taken is the total sum
        }
        
        // Step 2: Perform Binary Search on the range [low, high]
        while(low <= high)
        {
            int mid = low + (high - low) / 2; // Midpoint calculation to avoid integer overflow
            
            // If it's possible to paint within 'mid' time
            if(PaintersPaintWall(arr , mid , k))
            {
                high = mid - 1; // Try to look for a smaller/better maximum time in the left half
            }
            else
            {
                low = mid + 1;  // 'mid' is too small, need more time limit, search the right half
            }
        }
        
        // 'low' will eventually converge to the minimum possible maximum time
        return low;
    }
}
