class Solution {
    public int kthGrammar(int n, int k) {
        if(n==1) return 0;
        int tE=(int)Math.pow(2,n-1);
        if(k-tE/2<=0) return kthGrammar(n-1,k);
        int kthGrammarNB2 = kthGrammar(n-1,k-tE/2);
        if(kthGrammarNB2==1) return 0;
        return 1;
    }
}