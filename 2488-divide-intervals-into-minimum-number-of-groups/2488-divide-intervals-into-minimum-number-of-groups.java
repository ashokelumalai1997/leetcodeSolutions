class CustomComparator implements Comparator<int[]>  {
    public int compare(int[] a, int[] b) {
        if(a[0] == b[0]) return Integer.compare(a[1], b[1]);
        return Integer.compare(a[0], b[0]);
    }
}
class Solution {
    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        int[][] events = new int[2*n][2];
        for(int i = 0; i < n; i++) {
            events[i][0] = intervals[i][0];
            events[i][1] = 1;
            events[n+i][0] = intervals[i][1] + 1;
            events[n+i][1] = -1;
        }
        Arrays.sort(events, new CustomComparator());
        int result = 0;
        int current = 0;
        for(int i = 0; i < 2*n; i++) {
            current += events[i][1];
            result = Math.max(result, current);
        }
        return result;

    }
}


/*

intervals int[][]

interval [] -> [left, right] both inclusive

-> divide intervals into groups
-> each interval is in exactly one group
-> same group should not contain intersecting intervals

minimum number of groups 

Observation : a interval should be included in existing group if there is a group that has no intersection. Otherwise, we can add it to a new group

Maintain a groups
for each interval check if it there is any existing group that doesn't collide
    if yes add the interval to the group
    else create a new group with new interval and add it to groups


O(n^2) in the worst case


1,5 1,10 2,3 5,10 6,8

1 > 2,3
2 > 1, 3,4
3 > 1,2
4 > 2
5 

5

1,2,3,4



*/
