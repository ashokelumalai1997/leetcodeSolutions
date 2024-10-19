class Solution {
    public char findKthBit(int n, int k) {
        if(n == 1) return '0';
        if(k == (Math.pow(2,n))/2) return '1';
        else if(k < (Math.pow(2,n))/2) return findKthBit(n-1, k);
        else return (findKthBit(n-1, (int)Math.pow(2, n)-k) == '0') ? '1' : '0';
    }
}


