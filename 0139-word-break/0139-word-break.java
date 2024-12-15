class Solution {

    private boolean breakable(int[] memo, int ind, String s, Set<String> set) {
        if(ind == s.length()) return true;

        if(memo[ind] != -1) return memo[ind] == 1;

        boolean result = false;

        for(int i = ind + 1; i <= s.length(); i++) {
            if(set.contains(s.substring(ind, i))) {
                result = result || breakable(memo, i, s, set);
            }
        }

        memo[ind] = (result ? 1 : 0);

        return result;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();

        int[] memo = new int[s.length()];

        Arrays.fill(memo, -1);
        for(String word : wordDict) {
            set.add(word);
        }


        return breakable(memo, 0, s, set);
    }
}