class Solution {
    public int countDays(int days, int[][] meetings) {
        /*
        1. sort the input based on start time
        2. iterate one by one
        3. calculate difference between previous meeting and add it to total days
        */

        Arrays.sort(meetings, (a,b) -> a[0] - b[0]);

        int n = meetings.length;

        int previousEnd = 0;

        int total = 0;
        for(int i = 0; i < n; i++) {
            if(previousEnd < meetings[i][0]) {
                total += (meetings[i][0] - previousEnd - 1);
            }
            previousEnd = Math.max(previousEnd, meetings[i][1]);
        }

        return total + (days - previousEnd);
    }
}