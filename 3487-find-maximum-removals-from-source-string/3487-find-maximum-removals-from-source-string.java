class Solution {
    private int getMaxRemovals(int[][] dp, int index, int pIndex, String source, String pattern, int[] targetIndices) 
    {
        if(index == source.length()) {
            if(pIndex == pattern.length()) return 0;
            return Integer.MIN_VALUE;
        }

        if(pIndex == pattern.length()) {
            int next = getMaxRemovals(dp, index+1, pIndex, source, pattern, targetIndices);
            if(next != Integer.MIN_VALUE && targetIndices[index] == 1) next++;
            return next;
        }

        if(dp[index][pIndex] != -1) return dp[index][pIndex];

        int take = 0;
        int notTake = 0;
        notTake = getMaxRemovals(dp, index+1, pIndex, source, pattern, targetIndices);
        
        if(targetIndices[index] == 1) {
            
            if(notTake != Integer.MIN_VALUE) notTake++;
        }
        if(source.charAt(index) == pattern.charAt(pIndex)) {
            take = getMaxRemovals(dp, index+1, pIndex+1, source, pattern, targetIndices);
        } else {
            take = getMaxRemovals(dp, index+1, pIndex, source, pattern, targetIndices);
        }
        return dp[index][pIndex] = Math.max(take, notTake);
    }
    public int maxRemovals(String source, String pattern, int[] targetIndices) {
        int n = source.length();
        int[] tIndices = new int[n];
        for(int i : targetIndices) tIndices[i] = 1;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        return getMaxRemovals(dp, 0, 0, source, pattern, tIndices);
    }
}

/*

String source n;
String pattern m;

pattern is a subseq of source

int[] targetIndices > some indices of source in order

Operation :
Remove char at index idx from source provided
1. idx is in targetIndices
2. pattern remains a subseq of source

Return  :  Maximum number of operations that can be performed



Iterate all the subsets of targetIndices and check if pattern stays subseq after applying the ops

Get max len of such subsets

00001
00010
00011
00100
00101
00110
00111


aaaabbbbbaaaabbbbbccccc abc  [0,1,3,7,10]

f(sourceIndex, targetIndexMap, tracker) {

}

*/