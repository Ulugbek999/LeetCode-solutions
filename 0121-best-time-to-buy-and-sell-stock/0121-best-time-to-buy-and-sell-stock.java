class Solution {
    public int maxProfit(int[] prices) {

        
        int left = 0;
        int maxProfit = 0;

        for(int right = 0; right < prices.length; right++){

            int profit = 0;

            while(prices[right] < prices[left]){
                
                left++;
            }

            profit = prices[right] - prices[left];
            maxProfit = Math.max(profit, maxProfit);


        }

        return maxProfit;

        
    }
}