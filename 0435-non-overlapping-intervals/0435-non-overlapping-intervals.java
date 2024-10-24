class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[1]-b[1]);
        int currentEnd = intervals[0][1];
        int n = intervals.length;
        int count = 0;
        for(int i = 1; i < n; i++) {
            if(intervals[i][0] < currentEnd) {
                count++;
            } else {
                currentEnd = intervals[i][1];
            }
        }
        return count;
    }
}

// dontTake should be option for all the intervals
// take should only be an option if it doesnt overlap with last interval

//                 index 0
//                 1+f(index+1, -INF) f(index+1, int[index][1])


// _____________
//     ______________
//      __________
//                     ____________

// ____________________________
//     _________________
//                       ______
//                         ____________________________
//                             ___________
//                                         __
//                                             ___
//                                                  ____
        


