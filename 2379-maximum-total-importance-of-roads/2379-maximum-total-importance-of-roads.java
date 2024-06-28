class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] degreeCount = new int[n];
        for(int[] road : roads) {
            degreeCount[road[0]]++;
            degreeCount[road[1]]++;
        }
        Arrays.sort(degreeCount);
        long result = 0;
        for(int i = 0; i < n; i++) {
            result += (long)degreeCount[i]*(i+1);
        }
        return result;
    }
}