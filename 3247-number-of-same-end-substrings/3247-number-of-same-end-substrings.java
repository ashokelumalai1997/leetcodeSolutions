class Solution {
    public int[] sameEndSubstringCount(String s, int[][] queries) {
        int n = s.length();
        int[][] counter = new int[n+1][26];

        for(int i = 1; i < n+1; i++) {
            for(int j = 0; j < 26; j++) {
                counter[i][j] = counter[i-1][j];
            }
            counter[i][s.charAt(i-1) - 'a']++;
        }

        int[] res = new int[queries.length];

        for(int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            int count = 0;

            for(int j = 0; j < 26; j++) {
                int c = counter[end+1][j] - counter[start][j];
                count += c*(c+1)/2;
            }

            res[i] = count;
        }
        return res;
    }
}