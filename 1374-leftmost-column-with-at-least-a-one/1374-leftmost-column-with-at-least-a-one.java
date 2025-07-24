/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dims = binaryMatrix.dimensions();
        int m = dims.get(0);
        int n = dims.get(1);

        int currentR = 0;
        int currentC = n-1;

        int lMost = -1;

        while(currentR < m && currentC >= 0) {
            int current = binaryMatrix.get(currentR, currentC);
            if(current == 1) {
                lMost = currentC;
                currentC--;
                continue;
            }
            currentR++;
        }

        return lMost;
    }
}