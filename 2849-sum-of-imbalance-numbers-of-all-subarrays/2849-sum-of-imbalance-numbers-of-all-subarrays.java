class Solution {
    public int sumImbalanceNumbers(int[] nums) {
        int n = nums.length;
        int result = 0;
        for(int i = 0; i < n; i++) {
            TreeSet<Integer> st = new TreeSet<>();
            st.add(nums[i]);
            int cres = 0;
            for(int j = i + 1; j < n; j++) {
                
                // if(s == true) {
                    Integer l = st.floor(nums[j]);
                    Integer u = st.ceiling(nums[j]);
                    if(l != null && nums[j] - l > 1) cres++;
                    if(u != null && u - nums[j] > 1) cres++;
                    if(l != null && u != null && u - l > 1) cres--;
                    st.add(nums[j]);
                // }

                // int[] track = new int[n+1];
                // for(int k = i; k <= j; k++) {
                //     track[nums[k]]++;
                // }
                // int l = 0;
                // while(track[l] == 0 && l < n+1) l++;
                // int prev = l;
                // int cres = 0;
                // for(int o = l+1; o <= n; o++) {
                //     if(track[o] != 0) {
                //         if(o - prev > 1) cres++;
                //         prev = o;
                //     }
                // }
                result += cres;
            }
        }
        return result;
    }
}
