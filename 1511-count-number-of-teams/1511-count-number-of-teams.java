class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int result = 0;
        for(int i = 0; i < n; i ++) {
            int count = 0;
            int c = 0;
            for(int j = 0; j < i; j ++) {
                if(rating[j] > rating[i]) {
                    count++;
                }
                if(rating[j] < rating[i]) {
                    c++;
                }
            }
            int count1 = 0;
            int c1 = 0;
            for(int j = i+1; j < n; j ++) {
                if(rating[j] < rating[i]) {
                    count1++;
                }
                if(rating[j] > rating[i]) {
                    c1++;
                }
            }
            result += (count1*count) + (c*c1);

        }
        return result;
    }
}