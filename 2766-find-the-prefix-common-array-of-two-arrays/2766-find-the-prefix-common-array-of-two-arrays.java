class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        

        int n = A.length;

        int[] counterA = new int[n+1];
        int[] counterB = new int[n+1];

        int[] result = new int[n];

        for(int i = 0; i < n; i++) {
            counterA[A[i]]++;
            counterB[B[i]]++;
            int count = 0;
            for(int j = 0; j < n+1; j++) {
                count += Math.min(counterA[j], counterB[j]);
            }

            result[i] = count;
        }

        return result;
    }
}