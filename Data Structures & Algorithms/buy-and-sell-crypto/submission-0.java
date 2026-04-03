class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyPrice = prices[0];
        for(int i=1;i<prices.length;i++) {
            int currProfit = prices[i] - buyPrice;
            maxProfit = Math.max(maxProfit, currProfit);
            if(currProfit < 0) {
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }
}
