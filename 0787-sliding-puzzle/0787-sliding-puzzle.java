class Solution {
    private boolean isValid(int[][] board) {
        if(board[0][0] != 1) return false;
        if(board[0][1] != 2) return false;
        if(board[0][2] != 3) return false;
        if(board[1][0] != 4) return false;
        if(board[1][1] != 5) return false;
        if(board[1][2] != 0) return false;
        return true;
    }

    private void swap(int[][] board, int x, int y, int x1, int y1) {
        int temp = board[x][y];
        board[x][y] = board[x1][y1];
        board[x1][y1] = temp;
    }

    private String boardEntry(int[][] board) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(board[0][0]));
        sb.append(String.valueOf(board[0][1]));
        sb.append(String.valueOf(board[0][2]));
        sb.append(String.valueOf(board[1][0]));
        sb.append(String.valueOf(board[1][1]));
        sb.append(String.valueOf(board[1][2]));
        return sb.toString();
    }

    private void fixBoard(int[][] board, int zeroIndX, int zeroIndY, 
                    int[] result, int moces, Map<String, Integer> boardSet) {
        if(isValid(board)) {
            result[0] = Math.min(moces, result[0]);
            return;
        }
        String boardEntry = boardEntry(board);
        if(boardSet.containsKey(boardEntry) && boardSet.get(boardEntry) < moces) return;
        boardSet.put(boardEntry, moces);
        if(zeroIndX-1 >= 0) {
            swap(board, zeroIndX-1, zeroIndY, zeroIndX, zeroIndY);
            fixBoard(board, zeroIndX-1, zeroIndY, result, moces+1, boardSet);
            swap(board, zeroIndX, zeroIndY, zeroIndX-1, zeroIndY);
        }
        if(zeroIndX+1 <= 1) {
            swap(board, zeroIndX+1, zeroIndY, zeroIndX, zeroIndY);
            fixBoard(board, zeroIndX+1, zeroIndY, result, moces+1, boardSet);
            swap(board, zeroIndX, zeroIndY, zeroIndX+1, zeroIndY);
        }
        if(zeroIndY-1 >= 0) {
            swap(board, zeroIndX, zeroIndY-1, zeroIndX, zeroIndY);
            fixBoard(board, zeroIndX, zeroIndY-1, result, moces+1, boardSet);
            swap(board, zeroIndX, zeroIndY, zeroIndX, zeroIndY-1);
        }
        if(zeroIndY+1 <= 2) {
            swap(board, zeroIndX, zeroIndY+1, zeroIndX, zeroIndY);
            fixBoard(board, zeroIndX, zeroIndY+1, result, moces+1, boardSet);
            swap(board, zeroIndX, zeroIndY, zeroIndX, zeroIndY+1);
        }

    }
    public int slidingPuzzle(int[][] board) {
        int[] result = new int[]{Integer.MAX_VALUE};
        int zeroIndX = -1;
        int zeroIndY = -1;
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i][j] == 0) {
                    zeroIndX = i;
                    zeroIndY = j;
                }
            }
        }
        Map<String, Integer> boardSet = new HashMap<>();
        fixBoard(board, zeroIndX, zeroIndY, result, 0, boardSet);
        return result[0] == Integer.MAX_VALUE ? -1 : result[0];
    }
}