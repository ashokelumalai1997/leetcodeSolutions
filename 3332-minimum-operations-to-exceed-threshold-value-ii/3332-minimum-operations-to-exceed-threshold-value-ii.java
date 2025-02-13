class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>((a,b) -> Long.compare(a,b));


        int n = nums.length;

        for(int i = 0; i < n; i ++) {
            pq.offer((long)nums[i]);
        }

        int op = 0;

        while(pq.size() >= 2 && pq.peek() < k) {
            op++;
            Long min1 = pq.poll();
            Long min2 = pq.poll();
            pq.offer(min1*2 + min2);
        }

        return op;
    }
}