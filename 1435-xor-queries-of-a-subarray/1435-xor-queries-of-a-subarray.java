class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int totalXOR = 0;
        int[] prefixXOR = new int[n];
        int[] suffixXOR = new int[n];
        int XORTracker = 0;
        int XORTrackerReverse = 0;
        for(int i = 0; i < n; i++) {
            totalXOR ^= arr[i];
            XORTracker ^= arr[i];
            prefixXOR[i] = XORTracker;

            XORTrackerReverse ^= arr[n-1-i];
            suffixXOR[n-1-i] = XORTrackerReverse;
        }
        int queriesLength = queries.length;
        int[] result = new int[queriesLength];
        for(int i = 0; i < queriesLength; i++) {
            int[] query = queries[i];
            result[i] = totalXOR;
            if(query[0] != 0) result[i] ^= prefixXOR[query[0]-1];
            if(query[1] != n-1) result[i] ^= suffixXOR[query[1]+1];
        }
        return result;

    }
}