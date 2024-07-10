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
                    Collections.sort(triplet);
                    result.add(triplet);
                    i++;
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