class Solution {
    public int makePrefSumNonNegative(int[] nums) {
        int n = nums.length;

        int count = 0;

        long sum = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a-b);



        for(int i = 0; i < n; i++) {
            sum += nums[i];

            if(nums[i] < 0) pq.offer(nums[i]);
            if(sum < 0) {
                int rem = pq.poll();
                sum -= rem;
                count++;
            }
        }

        return count;
    }
}