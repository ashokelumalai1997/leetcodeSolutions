class Solution {

    
	public int[][] merge(int[][] intervals) {
		int n = intervals.length;

		if(n == 0) return new int[][]{};

		Arrays.sort(intervals, (a,b) -> {
			if(a[0] == b[0]) return a[1] - b[1];
			return a[0] - b[0];
});

int[] prev = intervals[0];

List<int[]> out = new ArrayList<>();

for(int[] current : intervals) {
	if(prev[1] >= current[0]) {
		prev[1] = Math.max(current[1], prev[1]);
} else {
	out.add(prev);
	prev = current;
}
}

out.add(prev);

int o = out.size();

int[][] outArr = new int[o][2];

for(int i = 0; i < o; i++) {
	outArr[i][0] = out.get(i)[0];
	outArr[i][1] = out.get(i)[1];
}

return outArr;

}
}
