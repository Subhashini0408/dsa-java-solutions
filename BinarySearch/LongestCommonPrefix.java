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
