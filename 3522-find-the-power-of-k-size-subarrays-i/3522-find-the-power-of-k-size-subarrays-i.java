class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = 0;

        int[] res = new int[n-k+1];

        Arrays.fill(res, -1);

        Deque<Integer> dq = new LinkedList<>();

        while(right < n) {
            while(!dq.isEmpty() && dq.peekFirst() < right-k+1) {
                dq.pollFirst();
            }
            if(!dq.isEmpty() && nums[dq.peekLast()] != nums[right]-1) {
                dq.clear();
            } 
            dq.offerLast(right);
            if(dq.size() == k) {
                res[dq.peekFirst()] = nums[right];
            }
            right++;
        }
        return res;

        // return res;

    }
}