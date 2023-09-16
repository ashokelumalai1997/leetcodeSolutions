class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        //int i=0;
        for(int num:nums){
            q.add(num);
            if(q.size()>k){
                q.poll();
            }
        }
        return q.peek();
    }
}