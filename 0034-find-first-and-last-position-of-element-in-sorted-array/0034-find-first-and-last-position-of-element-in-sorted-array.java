class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstOccurrence = this.findBound(nums, target, true);

        if (firstOccurrence == -1) {
            return new int[] { -1, -1 };
        }

        int lastOccurrence = this.findBound(nums, target, false);

        return new int[] { firstOccurrence, lastOccurrence };
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        int N = nums.length;
        int begin = 0, end = N - 1;
        int res = -1;

        while (begin <= end) {
            int mid = (begin + end) / 2;

            if (nums[mid] == target) {
                if (isFirst) {
                    // This means we found our lower bound.
                    res = mid;
                    end = mid - 1;
                } else {
                    res = mid;
                    begin = mid + 1;
                }
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }

        return res;
    }
}