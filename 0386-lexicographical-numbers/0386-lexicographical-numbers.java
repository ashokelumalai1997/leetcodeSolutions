class Solution {
    private void fillAllNums(int i, List<Integer> res, int n) {
        if(i > n) return;
        for(int j = 0; j <= 9; j++) {
            // int num = i*10 + j;
            if(i*10 + j > n) break;
            res.add(i*10 + j);
            fillAllNums(i*10 + j, res, n);
        }
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for(int i = 1; i <= 9 && i <= n; i++) {
            result.add(i);
            fillAllNums(i, result, n);
        }
        return result;
    }
}