class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rowCheck = new HashSet[9];
        Set<Character>[] colCheck = new HashSet[9];
        Set<Character>[] gridCheck = new HashSet[9];

        for(int i = 0; i < 9; i++) {
            gridCheck[i] = new HashSet<>();
            colCheck[i] = new HashSet<>();
            rowCheck[i] = new HashSet<>();
        }

        int n = 9;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == '.') continue;
                if(!rowCheck[i].add(board[i][j])) {
                    return false;
                }
                if(!colCheck[j].add(board[i][j])) {
                    return false;
                }
                int id = (i/3)*3 + j/3;
                if(!gridCheck[id].add(board[i][j])) {
                    return false;
                }
            }
        }

        return true;


    }
}