class Solution {

    int[][] rowTracker = new int[9][10];
    int[][] colTracker = new int[9][10];
    int[][] gridTracker = new int[9][10];

    private boolean valid(char[][] board, int r, int c, char option) {
        if(rowTracker[r][option - '0'] == 1) return false;
        if(colTracker[c][option - '0'] == 1) return false;

        int gridId = (r/3)*3 + c/3;

        if(gridTracker[gridId][option - '0'] == 1) return false;

        return true;
    }

    private boolean solveSudoku(char[][] board, int r, int c) {
        if(r == 9) {
            return true;
        }

        if(c == 9) {
            return solveSudoku(board, r+1, 0);
        }

        if(board[r][c] != '.') {
            return solveSudoku(board, r, c+1);
        }

        char[] options = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};

        for(char option : options) {
            if(valid(board, r, c, option)) {
                board[r][c] = option;
                int gridId = (r/3)*3 + c/3;
                rowTracker[r][option - '0'] = 1;
                colTracker[c][option - '0'] = 1;
                gridTracker[gridId][option - '0'] = 1;
                boolean solved = solveSudoku(board, r, c+1);
                if(solved) return true;
                rowTracker[r][option - '0'] = 0;
                colTracker[c][option - '0'] = 0;
                gridTracker[gridId][option - '0'] = 0;
                board[r][c] = '.';
            }
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') continue;
                int option = board[i][j] - '0';
                rowTracker[i][option] = 1;
                colTracker[j][option] = 1;
                int gridId = (i/3)*3 + j/3;
                gridTracker[gridId][option] = 1;
            }
        }
        solveSudoku(board, 0,0);
    }
}