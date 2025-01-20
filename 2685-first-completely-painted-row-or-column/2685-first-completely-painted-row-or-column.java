class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, Integer[]> mp = new HashMap<>();

        int m = mat.length;

        int n = mat[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                mp.put(mat[i][j], new Integer[]{i,j});
            }
        }

        int[] rs = new int[m];
        int[] cs = new int[n];
        Arrays.fill(rs, n);
        Arrays.fill(cs, m);

        int k = arr.length;

        for(int i = 0; i < k; i++) {
            Integer[] rc = mp.get(arr[i]);
            int r = rc[0];
            int c = rc[1];
            rs[r]--;
            cs[c]--;
            if(rs[r] == 0 || cs[c] == 0) return i;
        }

        return -1;
    }
}