class Solution {
	public int[][] kClosest(int[][] points, int k) {
		int n = points.length;
		int[][] res = new int[k][2];
		Arrays.sort(points, (a, b) -> dist(a) - dist(b));

		for(int i = 0; i < k; i++) {
			res[i] = points[i];
}

return res;
		
}

private int dist(int[] a) {
	return (int)(a[0]*a[0] + a[1]*a[1]);
}
}
