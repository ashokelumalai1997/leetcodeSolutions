class Solution {
    private boolean startsWithVowel(String word) {
        char firstChar = word.charAt(0);
        char lastChar = word.charAt(word.length() - 1);

        boolean f =  firstChar == 'a' || firstChar == 'e' || 
            firstChar == 'i' || firstChar == 'o' || firstChar == 'u';

        boolean l =  lastChar == 'a' || lastChar == 'e' || 
            lastChar == 'i' || lastChar == 'o' || lastChar == 'u';

        return l & f;
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefixCounter = new int[n+1];
        for(int i = 1; i <= n; i++) {
            if(startsWithVowel(words[i-1])) prefixCounter[i] = 1;
            prefixCounter[i] += prefixCounter[i-1];
        }


        int q = queries.length;
        int[] res = new int[q];

        for(int i = 0; i < q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            res[i] = prefixCounter[r+1] - prefixCounter[l];
        }

        return res;
    }
}