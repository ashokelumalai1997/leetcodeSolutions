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
        int ind = 0;
        while(ind < n-1 && res.charAt(ind) == '0') {
            ind++;
        }
        return res.substring(ind, res.length());
    }
}