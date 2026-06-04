/*
Problem: Reverse Pairs

Approach:
Use a modified Merge Sort to efficiently count reverse pairs.

A reverse pair is defined as:
nums[i] > 2 * nums[j] where i < j

1. Divide the array into two halves recursively.
2. Count reverse pairs in the left half.
3. Count reverse pairs in the right half.
4. Before merging, count cross reverse pairs where:
   - i belongs to the left half
   - j belongs to the right half
5. Use two pointers to count valid pairs efficiently since
   both halves are already sorted.
6. Merge the two sorted halves back together.
7. Sum all counts obtained from the left half, right half,
   and cross pairs.

Time Complexity: O(n log n)
- Merge Sort creates log n levels.
- Counting pairs and merging together take O(n) per level.

Space Complexity: O(n)
- Extra temporary array is used during the merge process.
*/

class Solution {
    public static void Conquer(int[] nums , int low , int mid , int high)
    {
        int[] temp = new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int i = 0;

        while(left <= mid && right <= high)
        {
            if(nums[left] <= nums[right])
            {
                temp[i] = nums[left];
                left++;
                i++;
            }
            else
            {
                temp[i] = nums[right];
                right++;
                i++;
            }
        }
        while(left <= mid)
        {
            temp[i] = nums[left];
            left++;
            i++;
        }
        while(right <= high)
        {
            temp[i] = nums[right];
            right++;
            i++;
        }
        for(int j = low ; j <= high ; j++)
        {
            nums[j] = temp[j - low];
        }
    }
    public static int CountPairs(int[] nums , int low , int mid , int high)
    {
        int right = mid + 1;
        int count = 0;

        for(int i = low ; i <= mid ; i++)
        {
            while(right <= high && nums[i] > (long) 2 * nums[right])
            {
                right++;
            }
            count += (right - (mid + 1));
        }
        return count;
    }
    public static int mergesort(int[] nums , int low , int high)
    {
        int count = 0;
        if(low >= high)
        {
            return 0;
        }
        int mid = (low + high) / 2;

        count += mergesort(nums , low , mid);
        count += mergesort(nums , mid+1 , high);

        count += CountPairs(nums , low , mid , high);

        Conquer(nums , low , mid , high);
        return count;
    }
    public int reversePairs(int[] nums) {  

        return mergesort(nums , 0 , nums.length - 1);

    }
}
