class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] res = new int[m][n];
        if(original.length != m*n) return new int[][]{};
        for(int i = 0; i < m*n; i++) {
            res[i/n][i%n] = original[i];
        }
        return res;
    }
}