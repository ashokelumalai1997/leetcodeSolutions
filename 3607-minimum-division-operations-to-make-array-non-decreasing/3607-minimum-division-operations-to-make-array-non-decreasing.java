class Solution {
    private int lowestFactor(int num) {
        for(int i = 2; i*i <= num; i++) {
            if(num%i == 0) return i;
        }
        return num;
    }
    public int minOperations(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int i = n-1;
        int res = 0;
        while(i >= 0) {
            int currentNum = nums[i];
            if(st.isEmpty()) {
                st.push(currentNum);
                i--;
                continue;
            }
            if(!st.isEmpty() && st.peek() < currentNum) {
                int stTopLFactor = lowestFactor(currentNum);
                if(st.peek() < stTopLFactor) {
                     return -1;
                    //currentNum = lfcn;
                }
                else {
                    // st.pop();
                    currentNum = stTopLFactor;
                    res++;
                }
            }
            st.push(currentNum);
            i--;
        }
        return res;
    }
}