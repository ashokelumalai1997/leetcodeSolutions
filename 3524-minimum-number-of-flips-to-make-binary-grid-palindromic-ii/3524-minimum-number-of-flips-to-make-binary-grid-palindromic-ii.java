class Solution {
    public int minFlips(int[][] grid) {
        int result = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        // if(m > 1 && n > 1) {
            
        for(int i = 0; i < m/2; i++) {
            for(int j = 0; j < n/2; j++) {
                int ones = 0;
                if(grid[i][j] == 1) ones++;
                if(grid[m-1-i][j] == 1) ones++;
                if(grid[i][n-1-j] == 1) ones++;
                if(grid[m-1-i][n-1-j] == 1) ones++;
                result += Math.min(ones, 4 - ones);
            }
        }
            
        // }
        int resultB = result;
        int onesR = 0;
        if(m%2 != 0) {
            for(int j = 0; j < n/2; j++) {
                if(grid[m/2][j] != grid[m/2][n-1-j]) result++;
                else if(grid[m/2][j] == 1) onesR+=2;
            }
        }
        int onesC = 0;
        if(n%2 != 0) {
            for(int j = 0; j < m/2; j++) {
                if(grid[j][n/2] != grid[m-1-j][n/2]) result++;
                else if(grid[j][n/2] == 1) onesC+=2;
            }
        }
        int ones = 0;
        if(m%2 != 0 && n%2 != 0) {
            if(grid[m/2][n/2] == 1) ones++;
        }
        int totalOnes = ones + onesR + onesC;
        int remainingOnes = totalOnes%4;
        int resultOdd = result - resultB;
        if(remainingOnes != 0 && ((2*resultOdd < 4 - remainingOnes))) {
            result += remainingOnes;
        } else {
            result += remainingOnes%2;
        }
        return result;
    }
}