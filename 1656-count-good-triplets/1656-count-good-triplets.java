class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        	int count = 0;
		int n = arr.length;
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				for(int k = j + 1; k < n; k++) {
					if(compare(arr[i], arr[j], a)
&& compare(arr[j], arr[k], b)
&& compare(arr[i], arr[k], c)) count++;
}
}
}

return count;

    }
    private boolean compare(int a, int b, int c) {
	return Math.abs(a - b) <= c;
}

}