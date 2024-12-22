class Solution {
    public int minimumOperations(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();

        for(int num : nums) {
            mp.putIfAbsent(num, 0);
            mp.put(num, mp.get(num)+1);
        }

        int tracker = 0;
        int ops = 0;

        int n = nums.length;

        while(tracker < n && mp.size() != (n)-tracker) {
            ops++;
            for(int i = 0; tracker < n && i < 3; i++) {
                mp.put(nums[tracker], mp.get(nums[tracker])-1);
                if(mp.get(nums[tracker]) == 0) {
                    mp.remove(nums[tracker]);
                }
                tracker++;
            }
        }


        return ops;

        
    }
}