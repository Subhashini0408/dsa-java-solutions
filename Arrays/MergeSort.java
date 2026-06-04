/*
Problem: Merge Sort

Approach:
Use the Divide and Conquer technique to sort the array.

1. Divide the array into two halves recursively until each
   subarray contains only one element.
2. Recursively sort the left half and the right half.
3. Merge the two sorted halves using a temporary array.
4. Compare elements from both halves and place the smaller
   element into the temporary array.
5. Copy the merged sorted elements back to the original array.
6. Repeat the process until the entire array is sorted.

Time Complexity: O(n log n)
- The array is divided into log n levels.
- At each level, merging takes O(n) time.

Space Complexity: O(n)
- Extra temporary array is used during merging.
*/

public class Solution {
	public static void Conquer(int[] arr , int low , int mid , int high)
	{
		int[] temp = new int[high - low + 1];

		int left = low;
		int right = mid + 1;
		int i = 0;

		while(left <= mid && right <= high)
		{
			if(arr[left] <= arr[right])
			{
               temp[i] = arr[left];
			   i++;
			   left++;
			}
			else
			{
				temp[i] = arr[right];
				right++;
				i++;
			}
		}
		//when right pointer finished before left pointer
		while(left <= mid)
		{
			temp[i] = arr[left];
			left++;
			i++;
		}
		//when left pointer finished before right pointer
		while(right <= high)
		{
			temp[i] = arr[right];
			right++;
			i++;
		}
		//copy the elements from temp arr to original arrays
		for(int j = low ; j <= high ; j++)
		{
			arr[j] = temp[j - low];
		}
	}
	public static void MergeSortingAlgorithm(int[] arr , int low , int high)
	{
		if(low >= high)
		{
			return;
		}
		int mid = (low + high) / 2;
        
		MergeSortingAlgorithm(arr , low , mid);
		MergeSortingAlgorithm(arr , mid + 1 , high);
		Conquer(arr , low , mid , high);
		
	}
	public static void mergeSort(int[] arr, int n) {

		 //edge cases
		 if(arr == null || arr.length == 0)
		 {
			 return;
		 }
		 MergeSortingAlgorithm(arr , 0 , n - 1);
	}
}
