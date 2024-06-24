class Solution {
    public int minKBitFlips(int[] nums, int k) {
        Queue<Integer> oneQ = new LinkedList<>();
        Queue<Integer> zeroQ = new LinkedList<>();
        int n = nums.length;
        int i = 0;
        int result = 0;
        Queue<Integer> temp = new LinkedList<>();
        int tempK = 0;
        while(i < n) {
            tempK = oneQ.size() + zeroQ.size();
            if(tempK == 0) {
                while(i < n && nums[i] == 1) i++;
            }
            while(i < n && tempK < k) {
                if(nums[i] == 0) zeroQ.offer(i);
                else oneQ.offer(i);
                i++;
                tempK++;
            }
            // if(i == n && oneQ.size() == 0 && zeroQ.size() == 0) return result;
            temp = oneQ;
            oneQ= zeroQ;
            zeroQ = temp;
            if(oneQ.size() == k) {
                oneQ.clear();
                result++;
                continue;
            }
            while(!oneQ.isEmpty() && !zeroQ.isEmpty() && (oneQ.peek() < zeroQ.peek())) {
                oneQ.poll();
            }
            if(oneQ.size() != 0 || zeroQ.size() != 0) result++;;
            
        }
        if(!oneQ.isEmpty()) return -1;
        if(!zeroQ.isEmpty()) {
            if(zeroQ.size() == k) result++;
            else return -1;
        }
        return result;
    }
}