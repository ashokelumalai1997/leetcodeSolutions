class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int result = 0;
        int emptyBottles = 0;
        while(numBottles != 0) {
            result += numBottles;
            emptyBottles += numBottles;
            numBottles = emptyBottles/numExchange;
            emptyBottles %= numExchange;
        }
        return result;
    }
}