class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int[] rowMinimum = new int[matrix.length];
        Arrays.fill(rowMinimum, Integer.MAX_VALUE);
        int[] colMaximum = new int[matrix[0].length];
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] < rowMinimum[i]) {
                    rowMinimum[i] = matrix[i][j];
                }
                if(matrix[i][j] > colMaximum[j]) {
                    colMaximum[j] = matrix[i][j];
                }
            }
        }
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == rowMinimum[i] && matrix[i][j] == colMaximum[j]) {
                    result.add(matrix[i][j]);
                }
                
            }
        }
        return result;
    }
}