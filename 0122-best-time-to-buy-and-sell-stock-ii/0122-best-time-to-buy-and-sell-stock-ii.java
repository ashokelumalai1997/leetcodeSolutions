class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int profit = 0;
        for(int price : prices) {
            buy = Math.min(buy, price);
            if(buy < price) {
                profit += (price-buy);
                buy = price;
            }
        }

        return profit;
    }
}