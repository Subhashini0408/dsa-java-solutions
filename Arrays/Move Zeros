/*
Problem: Move Zeroes

Approach:
Use two pointers to shift all non-zero elements
toward the beginning of the array while maintaining
their relative order.

1. Traverse the array using pointer 'i'.
2. Whenever a non-zero element is found,
   place it at index 'j' and increment 'j'.
3. After placing all non-zero elements,
   fill the remaining positions with zeroes.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0 ; i < nums.length ; i++)
        {
            if(nums[i] != 0)
            {
                nums[j] = nums[i];
                j++;
            }
        }
        while(j < nums.length)
        {
            nums[j] = 0;
            j++;
        }
        
    }
}
