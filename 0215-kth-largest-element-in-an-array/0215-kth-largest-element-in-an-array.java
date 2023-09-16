class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int i=0;
        while(i<nums.length){
            q.add(nums[i]);
            if(q.size()>k){
                q.poll();
            }
            i++;
        }
        return q.peek();
    }
}