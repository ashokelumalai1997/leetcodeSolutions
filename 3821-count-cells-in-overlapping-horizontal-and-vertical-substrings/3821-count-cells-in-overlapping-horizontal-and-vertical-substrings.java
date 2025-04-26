import java.util.HashSet;
import java.util.Set;

class Solution {

    private String getHString(char[][] grid) {
        StringBuilder sb = new StringBuilder();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(grid[i][j]);
            }
        }
        return sb.toString();
    }

    private String getVString(char[][] grid) {
        StringBuilder sb = new StringBuilder();
        int m = grid.length;
        int n = grid[0].length;
        for (int j = 0; j < n; j++) { // fixed column-major order
            for (int i = 0; i < m; i++) {
                sb.append(grid[i][j]);
            }
        }
        return sb.toString();
    }

    private int[] getKMP(String text, String pat) {
        int t = text.length();
        int p = pat.length();

        int[] KMPArr = new int[t + p + 1];
        String newPat = pat + '$' + text;
        int n = newPat.length();

        int i = 0, j = 1;
        while (j < n) {
            if (newPat.charAt(i) == newPat.charAt(j)) {
                KMPArr[j] = i + 1;
                i++;
                j++;
            } else if (i != 0) {
                i = KMPArr[i - 1];
            } else {
                j++;
            }
        }

        int[] res = new int[t];
        for (int o = p + 1; o < t + p + 1; o++) {
            res[o - p - 1] = KMPArr[o];
        }
        return res;
    }

    public int countCells(char[][] grid, String pattern) {
        String hString = getHString(grid);
        String vString = getVString(grid);
        int[] hKMP = getKMP(hString, pattern);
        int[] vKMP = getKMP(vString, pattern);

        int m = grid.length;
        int n = grid[0].length;
        int p = pattern.length();

        Set<Integer> positions = new HashSet<>();
        int lastValidPosition = Integer.MAX_VALUE;

        for (int i = m*n-1; i >= 0; i--) {
            if (hKMP[i] == p) lastValidPosition = i;
            if (lastValidPosition <= i + p - 1) {
                int rId = i / n;
                int cId = i % n;
                positions.add(rId * n + cId); // FIX: always row * n + col
            }
        }

        lastValidPosition = Integer.MAX_VALUE;
        int count = 0;

        for (int i = m*n-1; i >= 0; i--) {
            if (vKMP[i] == p) lastValidPosition = i;
            if (lastValidPosition <= i + p - 1) {
                int rId = i % m;
                int cId = i / m;
                if (!positions.add(rId * n + cId)) count++; // FIX: again row * n + col
            }
        }

        return count;
    }
}
