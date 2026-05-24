/*
Problem: Best Time to Buy and Sell Stock

Approach:
Use a greedy single-pass approach to maximize profit.

1. Maintain a variable to track the minimum price seen so far.
2. Iterate through the array of stock prices.
3. At each step:
   - Update the minimum price if current price is lower.
   - Otherwise calculate profit if sold today:
     profit = current price - minimum price
4. Keep updating the maximum profit found so far.
5. At the end, return the maximum profit.

Greedy Observation:
Instead of checking all buy-sell pairs,
we always try to buy at the lowest price so far
and sell at the current price to maximize profit.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int maxProfit(int[] prices) {
        
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++) {

            if(prices[i] < minPrice) {
                minPrice = prices[i];
            }
            else {
                int profit = prices[i] - minPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }
}
