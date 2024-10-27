class Solution {
    public boolean checkSquare(int i, int j, int k, int[][] mat) {
        // for (int ii = i; ii <= i + k; ii++) {
        //     for (int jj = j; jj <= j + k; jj++) {
        //         if (mat[ii][jj] == 0) return false;
        //     }
        // }
        for(int ii = i; ii <= i+k; ii++) if(mat[ii][j+k] == 0) return false;
        for(int ii = j; ii <= j+k; ii++) if(mat[i+k][ii] == 0) return false;
        return true;
    }
    
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int total = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 1) continue;
                
                int mats = 0;
                for (int k = 0; k + i < m && k + j < n; k++) {
                    if (checkSquare(i, j, k, matrix)) {
                        mats++;
                    } else {
                        break;
                    }
                }
                total += mats;
            }
        }
        return total;
    }
}
