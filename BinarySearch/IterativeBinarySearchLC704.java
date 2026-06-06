// Problem: Binary Search
//
// Approach:
// Use a divide-and-conquer approach to search for the target element
// in a sorted array.
//
// 1. Initialize two pointers:
//    - low = 0
//    - high = n - 1
//
// 2. While low <= high:
//    - Find the middle index:
//      mid = (low + high) / 2
//
// 3. Compare target with nums[mid]:
//    - If equal, return mid.
//    - If target is smaller, search the left half.
//    - If target is greater, search the right half.
//
// 4. Continue until the target is found or the search space becomes empty.
//
// 5. Return -1 if the target is not present in the array.
//
// Observation:
// Since the array is sorted, each comparison eliminates half of the
// remaining search space, making the search efficient.
//
// Time Complexity: O(log n)
// Space Complexity: O(1)


class Solution {
    public int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while(low <= high)
        {
            int mid = (low + high) / 2;

            if(target == nums[mid])
            {
                return mid;
            }
            else if(target < nums[mid])
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return -1;
    }
}
