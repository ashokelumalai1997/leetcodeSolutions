class Solution {
    public int tupleSameProduct(int[] nums) {

        int n = nums.length; 

        Map<Integer, Integer> pMap = new HashMap<>();

        int res = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {

                int prevCount = pMap.getOrDefault(nums[i]*nums[j], 0);
                
                pMap.put(nums[i]*nums[j], prevCount+1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : pMap.entrySet()) {
            int val = entry.getValue();
            res += (val-1)*val*8/2;

        }

        return res;
    }
}