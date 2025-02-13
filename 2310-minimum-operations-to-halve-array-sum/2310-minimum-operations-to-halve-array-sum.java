class Solution {
    public int halveArray(int[] nums) {
        int n = nums.length;


        PriorityQueue<Double> pq = new PriorityQueue<>((a,b) -> Double.compare(b,a));

        double sum = 0;


        for(int i = 0; i < n; i ++) {
            pq.offer((double)nums[i]);
            sum += nums[i];
        }

        double req = sum/2.0;

        int ops = 0;

        while(sum > req) {
            double max = pq.poll();
            sum -= max/2.0;
            pq.offer(max/2.0);
            ops++;
        }

        return ops;




    }
}