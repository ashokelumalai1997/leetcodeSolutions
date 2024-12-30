class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] tracker = new int[high+1];
        // tracker[zero] += 1;
        // tracker[one] += 1;
        tracker[0] = 1;
        int mod = 1000000007;
        int total = 0;
        for(int i = 1; i <= high; i++) {
            if(i >= zero) tracker[i] += tracker[i-zero];
            if(i >= one) tracker[i] += tracker[i-one];
            tracker[i] %= mod;

            if(i >= low && i <= high) total += tracker[i];
            total %= mod;
            
        }

        // int answer = 0;
        // for (int i = low; i <= high; ++i) {
        //     answer += tracker[i];
        //     answer %= mod;
        // }
        // return answer;

        return total;

    }
}