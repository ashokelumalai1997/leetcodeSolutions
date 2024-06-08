class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int prefixMod = 0;
        HashMap<Integer, Integer> prefixModSeen = new HashMap<>();
        prefixModSeen.put(0, -1);
        for(int i = 0; i < nums.length; i ++) {
            prefixMod = (prefixMod + nums[i])%k;
            if(prefixModSeen.containsKey(prefixMod)) {
                if((i - prefixModSeen.get(prefixMod)) > 1) {
                    return true;
                }
            } else {
                prefixModSeen.put(prefixMod, i);
            }
        }
        return false;
    }
}