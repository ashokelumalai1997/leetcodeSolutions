class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Set<Integer> dups = new HashSet<>();
        // Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) if (dups.add(nums[i])) {
            Set<Integer> seen = new HashSet<>();
            for (int j = i + 1; j < nums.length; ++j) {
                int complement = -nums[i] - nums[j];
                if (seen.contains(complement)) {
                    List<Integer> triplet = Arrays.asList(
                        nums[i],
                        nums[j],
                        complement
                    );
                    Collections.sort(triplet);
                    res.add(triplet);
                }
                seen.add(nums[j]);
            }
        }
        return new ArrayList(res);
    }
}