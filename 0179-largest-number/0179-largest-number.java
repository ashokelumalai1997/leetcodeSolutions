class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] numStrings = new String[n];
        for(int i = 0; i < n; i++) {
            numStrings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numStrings, (a,b) -> (b+a).compareTo(a+b));
        String res = new String();
        for(String a : numStrings) res += a;
        if(res.startsWith("0")) return "0";
        return res;
    }
}