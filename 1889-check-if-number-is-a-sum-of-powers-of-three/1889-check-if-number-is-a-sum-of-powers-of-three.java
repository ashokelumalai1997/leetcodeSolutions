class Solution {
    private boolean isPossible(int ind, int n) {
        if(n == 0) {
            return true;
        }

        if(n < 0) return false;

        if(Math.pow(3, ind) > n) return false;
        int pow = (int)Math.pow(3, ind);
        boolean notTake = isPossible(ind+1, n);
        boolean take = isPossible(ind+1, n-pow);

        return notTake || take;

        // int next =  + isPossible(ind+1, n);
    }
    public boolean checkPowersOfThree(int n) {
        return isPossible(0, n);
    }
}