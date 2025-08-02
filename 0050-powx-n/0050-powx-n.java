class Solution {
    public double myPow(double x, int n) {
        
        return pow(x, n);
    }

    public double pow(double x, long n) {
        
        if(n == 0) return 1;
        if(n == 1) return x;
        boolean neg = false;
        if(n < 0) {
            return 1/pow(x, -1*n);
        }
        double res = pow(x, n/2);
        double result = 0;
        if(n%2 == 0) return res*res;
        result = res*res*x;

        return result;
    }
}