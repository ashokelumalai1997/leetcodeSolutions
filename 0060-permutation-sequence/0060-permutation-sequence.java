class Solution {
    private void getPerm(int ind, char[] chArr, 
            char[] chIn, int n, int k, boolean[] visited, String[] result, int[] counter) 
    {
        
        if(ind == n) {
            if(counter[0] == (k+1)) return;
            counter[0]++;
            result[0] = new String(chArr);
            return;
        }
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                chArr[ind] = chIn[i];
                getPerm(ind+1, chArr, chIn, n, k, visited, result, counter);
                chArr[ind] = '-';
                visited[i] = false;
            }
        }
    }
    public String getPermutation(int n, int k) {
        char[] chArr = new char[n];
        char[] chIn = new char[n];
        boolean[] visited = new boolean[n];
        for(int i = 1; i <= n; i++) {
            chIn[i-1] = (char)('0' + i);
        }
        String[] result = new String[]{""};
        int[] counter = new int[]{1};
        getPerm(0, chArr, chIn, n, k, visited, result, counter);
        return result[0];
    }
}