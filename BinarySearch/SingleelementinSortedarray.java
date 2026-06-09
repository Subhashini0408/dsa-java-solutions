Problem: Single Element in a Sorted Array

Approach:
Use Binary Search to find the single non-duplicate element in O(log n) time.

1. Handle edge cases:
   - If the array contains only one element, return it.
   - Check if the first or last element is the unique element.

2. Apply Binary Search:
   - Find the middle index.
   - If the middle element is different from both neighbors, it is the answer.
   - Otherwise, use the index parity pattern:
     - Before the single element, pairs start at even indices.
     - After the single element, this pattern breaks.

3. Based on the parity and matching pair, decide whether to search the left or right half.

4. Continue until the unique element is found.

Time Complexity: O(log n)
Space Complexity: O(1)

CODE : 

class Solution {
    public int singleNonDuplicate(int[] nums) {

       //optimized approach - O(log n)

       if(nums.length == 1)
       {
          return nums[0];
       }
       if(nums[0] != nums[1])
       {
         return nums[0];
       }
       if(nums[nums.length - 1] != nums[nums.length - 2])
       {
          return nums[nums.length - 1];
       }

       int low = 1;
       int high = nums.length - 2;

       while(low <= high)
       {
           int mid = low + (high - low) / 2;

           if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])//if suppose mid ia an answer
           {
              return nums[mid];
           }

           //if mid is not an answer then we check for left
           if((mid % 2 == 1 && nums[mid] == nums[mid - 1]) || (mid % 2 == 0 && nums[mid] == nums[mid + 1]))
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
