/*
Problem: Container With Most Water

Approach:
Use two pointers placed at the beginning and end of the array.

1. Calculate the width between the two pointers.
2. The container height is determined by the smaller height
   between the two lines.
3. Compute the area and update the maximum area if needed.
4. Move the pointer pointing to the smaller height because
   only a taller line can potentially increase the area.
5. Continue until both pointers meet.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int maxArea(int[] height) {

        //two pointers technique
        int left = 0;
        int right = height.length - 1;
        int maxarea = 0;

        while(left < right)
        {
            int width = right - left;
            int minheight = Math.min(height[left] , height[right]);

            maxarea = Math.max(maxarea , width * minheight);

            if(height[left] < height[right])
            {
                left++;
            }
            else if(height[right] < height[left])
            {
                right--;
            }
            else
            {
                left++;
                right--;
            }
        }
        return maxarea;
    }
}
