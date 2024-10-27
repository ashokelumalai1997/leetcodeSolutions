 class Solution {
    public boolean checkCols(int i, int j, int k, int[][] mat) {
        for(int ii = i; ii <= i+k; ii++) {
            if(mat[ii][j+k] == 0) return false;
        }
        return true;
    }

    public boolean checkRows(int i, int j, int k, int[][] mat) {
        for(int jj = j; jj <= j+k; jj++) {
            if(mat[i+k][jj] == 0) return false;
        }
        return true;
    }
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int total = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] != 1) continue;
                int mats = 0;
                for(int k = 0; k < Math.max(m,n); k++) {
                    if(i+k < m && j+k < n && matrix[i+k][j+k] == 1) {
                        if(checkRows(i, j, k, matrix) && checkCols(i, j, k, matrix)) mats++;
                        else break;
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


// for every m,n 300*300
//     IF CURRENT CELL HAS 1
//         for every right down ddiagonal cell n 300
//             check all the sub mat cells (m*n) 300*300
        

