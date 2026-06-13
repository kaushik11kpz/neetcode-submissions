class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        int buyPrice=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            buyPrice=Math.min(buyPrice,prices[i]);
            maxProfit=Math.max(maxProfit,prices[i]-buyPrice);
        }
        return maxProfit;
    }
}
