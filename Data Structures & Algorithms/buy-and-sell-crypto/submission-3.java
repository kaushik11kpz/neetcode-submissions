class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int maxProfit=0;
        int buyPrice=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            buyPrice=Math.min(buyPrice,prices[i]);
            maxProfit=Math.max(maxProfit,prices[i]-buyPrice);
        }
        return maxProfit;
    }
}
