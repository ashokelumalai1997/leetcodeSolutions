class NumArray {
    
    int[] segmentTree;
    int n;
    int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        
        this.segmentTree = new int[4*n];
        build(0, n-1, 1);
        
    }
    
    private void build(int left, int right, int s) {
        if(left == right) {
            segmentTree[s] = nums[left];
            return;
        }
        int mid = left + (right - left)/2;
        build(left, mid, 2*s);
        build(mid + 1, right, 2*s + 1);
        segmentTree[s] = segmentTree[2 * s] + segmentTree[2 * s + 1];
    }
    
    public void update(int index, int val) {
        
        updateSegment(index, 0, n-1, 1, val - nums[index]);
        nums[index] = val;
    }
    
    private void updateSegment(int index, int left, int right, int s, int val) {
        if(index < left || index > right) {
            return;
        }
        segmentTree[s] += val;
        if(left == right) return;
        int mid = left + (right - left)/2;
        updateSegment(index, left, mid, 2*s, val);
        updateSegment(index, mid + 1, right, 2*s + 1, val);
    }
    
    public int sumRange(int left, int right) {
        return sumSegment(0, n-1, 1, left, right);
    }
    
    private int sumSegment(int left, int right, int s, int qleft, int qright) {
        if(left > qright || right < qleft) {
            return 0;
        }
        if(left >= qleft && right <= qright) {
            return segmentTree[s];
        }
        int mid = left + (right - left)/2;
        return sumSegment(left, mid, 2*s, qleft, qright) + sumSegment(mid + 1, right, 2*s + 1, qleft, qright);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */