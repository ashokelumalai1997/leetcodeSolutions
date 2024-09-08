class Solution {
    private boolean canDo(int[] start, int target, int d) {
        int prev = start[0];
        int i = 1;
        int n = start.length;
        while(i < n) {
            if(start[i] - prev < target) {
                if(prev+target > start[i] + d) return false;
                prev = Math.min(prev + target, start[i] + d);
            } else {
                prev = start[i];
            }
            i++;
        }
        return true;
    }
    public int maxPossibleScore(int[] start, int d) {
        int n = start.length;
        Arrays.sort(start);
        int target = (start[n-1]+d - start[0])/(n-1);
        int left = 0;
        int right = target;
        int diff = 0;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(canDo(start, mid, d)) {
                left = mid + 1;
                diff = mid;
            } else {
                right = mid - 1;
            }
        }
        
        return diff;
    }
}

/*
start = [6,0,3], d = 2


end = [8, 2, 5]

0, 3, 6
2, 5, 8


3, 3



13, 13, 13


*/