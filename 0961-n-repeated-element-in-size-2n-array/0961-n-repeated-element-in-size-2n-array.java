class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums) {
            if(!set.add(num)) return num;
        }

        return 0;
    }
}