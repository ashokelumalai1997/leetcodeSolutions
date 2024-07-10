class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        int n = nums.length;
        int i = 0;
        int j = n-1;
        int k = i+1;
        while(k < n-1) {
            i = 0;
            j = n-1;
            while(i < j && i < k && j > k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) {
                    List<Integer> triplet = new ArrayList<Integer>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    // Collections.sort(triplet);
                    result.add(triplet);
                    // while(i < j && nums[i+1] == nums[i])i++;
                    i++;
                    // while(j-1>=i+1 && nums[j] == nums[j-1])j--;
                    j--;
                } else if(sum < 0) {
                    i++;
                } else {
                    j--;
                }
            }
            k++;
        }
        return new ArrayList<>(result);
    }
}