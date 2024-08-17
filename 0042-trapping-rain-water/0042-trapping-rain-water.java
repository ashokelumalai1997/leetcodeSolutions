class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int lmax = 0;
        int rmax = 0;
        for(int i = 0; i < n; i++) {
            leftMax[i] = lmax;
            lmax = Math.max(height[i], lmax);
            rightMax[n-1-i] = rmax;
            rmax = Math.max(height[n-1-i], rmax);
        }
        int result = 0;
        for(int i = 0; i < n; i++) {
            int ans = Math.min(leftMax[i], rightMax[i]) - height[i];
            result += ans >= 0 ? ans : 0;
        }
        return result;
    }
}