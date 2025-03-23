
class Solution {
	public int climbStairs( int n) {
		int first = 1;
        int second = 2;

        if(n < 3) return n;

        int k = 3;

        while(k <= n) {
            int current = first + second;
            first = second;
            second = current;
            k++;
        }

        return second;
    }
}
