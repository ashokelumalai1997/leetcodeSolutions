class Solution {
	public int[] findRightInterval(int[][] intervals) {
		
		int n = intervals.length;
        int[][] intervalsNew = new int[n][3];
		for(int i = 0; i < n; i++) {
            // intervalsNew[i]= new int[3];
			intervalsNew[i][0] = intervals[i][0];
			intervalsNew[i][1] = intervals[i][1];
			intervalsNew[i][2] = i;
}
		Arrays.sort(intervalsNew, (a,b) -> a[0] - b[0]);
		int[] output = new int[n];
		for(int i = 0; i < n; i++) {
			int currentEnd = intervalsNew[i][1];
			int rightIndex = bs(intervalsNew, currentEnd
, i, n-1);
			int originalIndex = intervalsNew[i][2];
			output[originalIndex] = rightIndex;
			
}


return output;
}

private int bs(int[][] intervalsNew, int currentEnd
, int left, int right) {

		int outputIndex = -1;
		while(left <= right) {
			int mid = left + (right - left)/2;
			if(intervalsNew[mid][0] >= currentEnd) {
				right = mid-1;
                outputIndex = intervalsNew[mid][2];
} else {

	left = mid+1;
}
}

return outputIndex;

 
}
}
