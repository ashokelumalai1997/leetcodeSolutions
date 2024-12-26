class Solution {
    private int addSubNoth(int id, int n, int[] nums, int target) {
        if(n == id) {
            if(target == 0) return 1;
            return 0;
        }

        int add = addSubNoth(id+1, n, nums, target - nums[id]);
        int sub = addSubNoth(id+1, n, nums, target + nums[id]);
        // int noth = addSubNoth(id+1, n, nums, target);

        return add + sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return addSubNoth(0, nums.length, nums, target);
    }
}