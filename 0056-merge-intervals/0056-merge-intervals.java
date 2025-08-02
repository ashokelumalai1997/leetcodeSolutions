class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> temp = new ArrayList<>();
        

        if(intervals.length == 0) return new int[][]{};


        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if(a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            }
        });

        int n = intervals.length;

        int[] current = intervals[0];

        for(int i = 1; i < n; i++) {
            if(intervals[i][0] <= current[1]) {
                current[0] = Math.min(intervals[i][0], current[0]);
                current[1] = Math.max(intervals[i][1], current[1]);
            } else {
                temp.add(current);
                current = intervals[i];
            }
        }

        temp.add(current);

        int newN = temp.size();

        int[][] res = new int[newN][2];

        for(int i = 0; i < newN; i++) {
            res[i] = temp.get(i);
        }

        return res;
    }
}