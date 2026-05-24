/*
Problem: Best Time to Buy and Sell Stock II

Approach:
Traverse through the array and capture every profitable transaction.
Whenever the current day's price is greater than the previous day's price,
add the profit difference to the total profit.

Time Complexity: O(n)
Space Complexity: O(1)
*/
lass Solution {
    public int maxProfit(int[] prices) {
       
       int todayprice = 0;
       int profitadd = 0;

       for(int tomm = 1 ; tomm < prices.length ; tomm++)
       {
          if(prices[tomm] > prices[todayprice])
          {
            int profit = prices[tomm] - prices[todayprice];
            profitadd += profit;
          }
          todayprice++;
       }
        return profitadd;
    }
}
