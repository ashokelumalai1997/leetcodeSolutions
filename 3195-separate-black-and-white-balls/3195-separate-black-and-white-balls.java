class Solution {
    public long minimumSteps(String s) {
        long res = 0;
        long numberOfOnes = 0;
        for(char c : s.toCharArray()) {
            if(c == '1') numberOfOnes++;
            else res += numberOfOnes;
        }
        return res;
    }
}



