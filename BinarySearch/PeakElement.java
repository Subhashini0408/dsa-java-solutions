/*
Problem: Find Peak Element

Approach:
Use Binary Search to find a peak element in O(log n) time.

A peak element is an element that is greater than its adjacent elements.
For boundary elements, out-of-bounds values are considered smaller.

Steps:
1. Handle edge cases:
   - If the array contains only one element, return index 0.
   - If the first element is greater than the second, return index 0.
   - If the last element is greater than its previous element, return the last index.

2. Apply Binary Search on the remaining range:
   - Calculate the middle index.
   - If arr[mid] is greater than both neighbors, it is a peak.
   - If arr[mid] is smaller than the right neighbor, move to the right half.
   - Otherwise, move to the left half.

3. Return the index of the peak element.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

import java.util.ArrayList;
public class Solution {
    public static int findPeakElement(ArrayList<Integer> arr) {
        
         if(arr.size() == 1)//The elements out of bounds are smaller than inside elemeents
         {
             return 0;
         }

         //first element checks with second
         if(arr.get(0) > arr.get(1))
         {
             return 0;
         }
         //last elements checks with its previous
         if(arr.get(arr.size() - 1) > arr.get(arr.size() - 2))
         {
             return arr.size() - 1;
         }

         int low = 1;
         int high = arr.size() - 2;

         while(low <= high)
         {
             int mid = low + (high - low) / 2;

             //checks mid front and back for mid + 1 < mid > mid - 1
             if(arr.get(mid - 1) < arr.get(mid) && arr.get(mid) > arr.get(mid + 1))
             {
                 return mid;
             }

             //if the mid lesser than mid + 1
             else if(arr.get(mid) < arr.get(mid + 1))
             {
                 low = mid + 1;
             }
             else
             {
                 high = mid - 1;
             }
         }
         return -1;
    }
}
