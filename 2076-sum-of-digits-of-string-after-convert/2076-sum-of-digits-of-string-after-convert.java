class Solution {
    private int getDigitSum(int num) {
        int dSum = 0;
        while(num != 0) {
            dSum += num%10;
            num /= 10;
        }
        return dSum;
    }
    public int getLucky(String s, int k) {
        int res = 0;
        for(char ch : s.toCharArray()) {
            res += getDigitSum(ch - 'a' + 1);
        }
        k--;
        while(k != 0) {
            res = getDigitSum(res);
            k--;
        }
        return res;
    }
}