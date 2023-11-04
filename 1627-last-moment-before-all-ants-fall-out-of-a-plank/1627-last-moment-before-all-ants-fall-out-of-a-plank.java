class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        Arrays.sort(left);
        Arrays.sort(right);
        int leftMax = Integer.MIN_VALUE;
        if(left.length!=0)
            leftMax = left[left.length-1];
        int rightMax = Integer.MIN_VALUE;
        if(right.length!=0)
            rightMax = n-right[0];
        return Math.max(leftMax,rightMax);
    }
}