class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        int k = 0;
        int i = k+1;
        int j = n-1;
        
        while(k < n-1) {
            i = k+1;
            j = n-1;
            while(i < j) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) {
                    List<Integer> triplet = new ArrayList<Integer>();
                    triplet.add(nums[i]);
                    triplet.add(nums[k]);
                    triplet.add(nums[j]);
                    // Collections.sort(triplet);
                    result.add(triplet);
                    while(i < j && nums[i+1] == nums[i])i++;
                    i++;
                    while(j-1>=i+1 && nums[j] == nums[j-1])j--;
                    j--;
                } else if(sum < 0) {
                    while(i < j && nums[i+1] == nums[i])i++;
                    i++;
                } else {
                    while(j-1>=i+1 && nums[j] == nums[j-1])j--;
                    j--;
                }
            }
            while(k+1 < n && nums[k+1] == nums[k]) k++;
            k++;
        }
        // return new ArrayList<>(result);
        return result;
    }
}