class Solution {
	public int maxProfit( int[] prices) {
		int profit = 0;
		int buy = prices[0];
		
		for(int price : prices) {
			if(buy > price) buy = price;
			int currentProfit = (price - buy);
			if(currentProfit > 0) {
                profit += currentProfit;
                buy = price;
            }
}

return profit;
}
}
