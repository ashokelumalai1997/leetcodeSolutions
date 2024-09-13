class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int totalXOR = arr[0];
        int[] prefixXOR = new int[n];
        prefixXOR[0] = arr[0];
        for(int i = 1; i < n; i++) {
            totalXOR ^= arr[i];
            prefixXOR[i] = prefixXOR[i-1] ^ arr[i];
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