class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //iterate over each element
        //check if front has anything before i-k-1, if yes pop it
        //check if back has any element lesser than current, if yes pop it
        //for every index from k-1 till n-1, push it to result
        //[1,3,-1,-3,5,3,6,7]
        //O[1,1,4,4,6,7]
        //E[3,3,5,5,6,7]
        int[] result = new int[nums.length-k+1];
        Deque<Integer> mq = new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            while(!mq.isEmpty()&&mq.peekFirst()<i-k+1){
                mq.pollFirst();
            }
            while(!mq.isEmpty()&&nums[mq.peekLast()]<nums[i]){
                mq.pollLast();
            }
            mq.offerLast(i);
            if(i>=k-1&&!mq.isEmpty()){
                result[i-k+1]=nums[mq.peekFirst()];
            }
        }
        return result;
    }
}