class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long result = 0;

        long zeroCount = 0;

        for(int num : nums) {
            if(num == 0) {
                zeroCount++;
            } else {
                result += (zeroCount*(zeroCount + 1)/2);
                zeroCount = 0;
            }
        }
        result += (zeroCount*(zeroCount + 1)/2);
        return result;
    }
}