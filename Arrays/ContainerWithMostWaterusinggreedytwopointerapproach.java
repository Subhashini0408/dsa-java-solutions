/*
Problem: Container With Most Water

Approach:
Use a greedy two pointer approach to maximize the water area.

1. Place one pointer at the beginning and another at the end.
2. Calculate the current container area using:
   - width between pointers
   - smaller height among the two walls
3. Update the maximum area if the current area is larger.
4. Move the pointer pointing to the smaller height because
   the smaller wall limits the water storage.
5. Skip heights that are smaller than or equal to the current height,
   since they cannot produce a larger area.
6. Continue until both pointers meet.

Greedy Observation:
Keeping the smaller wall cannot improve the area,
so we greedily search for a taller wall by moving that pointer.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int maxArea(int[] height) {
        
        int left = 0;
        int right = height.length - 1;
        int maxarea = 0;

        while(left < right)
        {
            int width = right - left;

            int minheight = (height[left] < height[right]) ? height[left] : height[right];

            int currarea = width * minheight;

            if(currarea > maxarea)
            {
                maxarea = currarea;
            }


            if(height[left] < height[right])
            {
                int currleft = height[left];

                while(left < right && height[left] <= currleft)
                {
                    left++;
                }
            }
            else
            {
                int currright = height[right];

                while(left < right && height[right] <= currright)
                {
                    right--;
                }
            }
            
        }
        return maxarea;
    }
}
