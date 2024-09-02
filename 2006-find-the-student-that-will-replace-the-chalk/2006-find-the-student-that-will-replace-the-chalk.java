class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for(int c : chalk) sum += c;
        k %= sum;
        int res = 0;
        for(int i = 0; i < chalk.length; i++) {
            if(k < chalk[i]) {
                res = i;
                break;
            }
            k -= chalk[i];
        }
        return res;
    }
}