class Solution {

    private void generatePerms(int[] nums, int ind, int n, List<Integer> tracker, 
                List<List<Integer>> res, boolean[] flag) {

        if(ind == n) {
            List<Integer> trackerCopy = new ArrayList<>();
            for(Integer i : tracker) {
                trackerCopy.add(i);
            }
            res.add(trackerCopy);
            return;
        }


        for(int i = 0; i < n; i++) {

            if(flag[i] == true) continue;
            tracker.add(nums[i]);

            flag[i] = true;

            generatePerms(nums, ind+1, n, tracker, res, flag);

            flag[i] = false;

            tracker.remove(tracker.size() - 1);
        }

        
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> tracker = new ArrayList<>();

        int n = nums.length;

        boolean[] flag = new boolean[n];

        generatePerms(nums, 0, n, tracker, res, flag);

        return res;
    }
}