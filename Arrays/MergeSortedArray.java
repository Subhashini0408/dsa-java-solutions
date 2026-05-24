/*
Problem: Merge Sorted Array

Approach:
Use three pointers starting from the end of the arrays.

1. Compare the last valid elements of nums1 and nums2.
2. Place the larger element at the end of nums1.
3. Move pointers accordingly.
4. If elements remain in nums2, copy them into nums1.

This avoids using extra space and performs the merge in-place.

Time Complexity: O(m + n)
Space Complexity: O(1)
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
       int i = m - 1;
       int j = n - 1;
       int k = m + n - 1;

       while(i >= 0 && j >= 0)
       {
         if(nums1[i] > nums2[j])
         {
            nums1[k] = nums1[i];
            i--;
         }
         else
         {
            nums1[k] = nums2[j];
            j--;
         }
         k--;
       }
       while(j >= 0)
       {
         nums1[k] = nums2[j];
         j--;
         k--;
       }



    }
}
