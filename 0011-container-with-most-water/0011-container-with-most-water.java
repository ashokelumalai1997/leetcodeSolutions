class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0;

        int n = height.length;

        int left = 0;
        int right = n-1;


        while(left < right) {
            int len = right - left;
            int width = Math.min(height[left], height[right]);
            maxWater = Math.max(maxWater, len*width);
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}