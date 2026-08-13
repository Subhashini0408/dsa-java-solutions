/*
 * Longest Common Prefix - Binary Search
 *
 * Approach:
 * - Find the length of the shortest string.
 * - Apply Binary Search on the prefix length.
 * - Check whether the prefix is common to all strings.
 * - If valid, search for a longer prefix.
 * - Otherwise, search for a shorter prefix.
 *
 * Example:
 * Input:  ["flower", "flow", "flight"]
 * Output: "fl"
 *
 * Time Complexity: O(N * M * log M)
 * Space Complexity: O(1)
 *
 * N = Number of strings
 * M = Length of the shortest string
 */

class Solution {
    private static boolean LongestCommonLength(String[] strs , int mid)
    {
        String prefix = strs[0].substring(0 , mid);

        for(int j = 1 ; j < strs.length ; j++)
        {
            if(!strs[j].startsWith(prefix))
            {
                return false;
            }
        }
        return true;
    }
    public String longestCommonPrefix(String[] strs) {

        if(strs.length == 1)
        {
            return strs[0];
        }

        int low = 0;
        int high = strs[0].length();

        for(String str : strs)
        {
            high = Math.min(high , str.length());
        }

        while(low <= high)
        {
            int mid = (low + high) / 2;
            if(LongestCommonLength(strs , mid))
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return strs[0].substring(0 , high);
    }
}
