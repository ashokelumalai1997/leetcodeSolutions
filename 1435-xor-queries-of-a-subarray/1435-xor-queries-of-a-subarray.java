class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int totalXOR = 0;
        int[] prefixXOR = new int[n];
        int XORTracker = 0;
        for(int i = 0; i < n; i++) {
            totalXOR ^= arr[i];
            XORTracker ^= arr[i];
            prefixXOR[i] = XORTracker;
        }
        int queriesLength = queries.length;
        int[] result = new int[queriesLength];
        for(int i = 0; i < queriesLength; i++) {
            int[] query = queries[i];
            result[i] = totalXOR;
            if(query[0] != 0) result[i] ^= prefixXOR[query[0]-1];
            result[i] ^= (totalXOR ^ prefixXOR[query[1]]);
        }
        return result;

    }
}