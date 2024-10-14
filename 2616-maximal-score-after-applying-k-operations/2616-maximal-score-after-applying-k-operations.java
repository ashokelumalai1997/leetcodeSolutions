class Solution {
    public long maxKelements(int[] nums, int k) {
        long result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int num : nums) pq.offer(num);
        while(k!=0 && !pq.isEmpty()) {
            int current = pq.poll();
            result += current;
            pq.offer((int)Math.ceil((double)current/3));
            k--;
        }
        return result;
    }
}