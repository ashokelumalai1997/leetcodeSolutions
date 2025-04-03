class Solution {
	public int[] xorQueries(int[] arr, int[][] queries) {
		int n = arr.length;
		int[][] prefix = new int[n+1][32];
		
		for(int i = 1; i < n+1; i++) {
			int index = 0;
			int num = arr[i-1];

            for (int b = 0; b < 32; b++) {
                prefix[i][b] = prefix[i - 1][b];
            }
			
			while(index < 32) {
				if( ((1 << index) & num) > 0)  {
					prefix[i][index]++;
}
if(i+1 < n+1)
prefix[i+1][index] = prefix[i][index];
index++;
}
}

int q = queries.length;

int[] res = new int[q];

for(int i = 0; i < q; i++) {
	int l = queries[i][0];
	int r = queries[i][1];
	int index = 0;
	
	int curr = 0;

	int count = (r - l + 1);

	while(index < 32) {
		if( (prefix[r+1][index] - prefix[l][index])%2 == 1 ) curr |= (1 << index);
		index++;
}
res[i] = curr;
}

return res;
}
}
