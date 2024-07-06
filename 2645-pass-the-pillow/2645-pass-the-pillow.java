class Solution {
    public int passThePillow(int n, int time) {
        time = time%(2*(n - 1)) + 1;
        return (time <= n - 1) ? (time) : (2*n - time);
    }
}