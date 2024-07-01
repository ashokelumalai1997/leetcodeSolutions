class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int numberOfOdds = 0;
        for(int a : arr) {
            numberOfOdds = a%2 == 1 ? numberOfOdds + 1 : 0 ;
            if(numberOfOdds == 3) return true;
        }
        return false;
    }
}