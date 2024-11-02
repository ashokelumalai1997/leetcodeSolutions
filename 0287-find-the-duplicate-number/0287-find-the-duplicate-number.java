class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for(int num : nums) {
            if(st.contains(num)) return num;
            st.add(num);
        }
        return 0;
    }
}