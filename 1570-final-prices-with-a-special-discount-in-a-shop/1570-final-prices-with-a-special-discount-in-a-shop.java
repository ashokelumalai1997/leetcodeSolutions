class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> st = new Stack<>();


        int n = prices.length;


        for(int i = 0; i < n; i ++)        {
            if(st.isEmpty() || prices[i] > prices[st.peek()]) {
                st.push(i);
            } else {
                while(!st.isEmpty() && prices[st.peek()] >= prices[i]) {
                    int ind = st.pop();
                    prices[ind] -= Math.min(prices[i], prices[ind]);
                }
                st.push(i);
            }
        }

        return prices;
    }
}