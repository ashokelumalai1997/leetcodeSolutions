class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        // Set<Character> st = new HashSet<>();
        int[] st = new int[26];
        for(Character ch : allowed.toCharArray()) st[ch - 'a'] = 1;
        int count = words.length;
        for(String word : words) {
            for(Character ch : word.toCharArray()) {
                if(st[ch - 'a'] != 1) {
                    count--;
                    break;
                }
            }
        }
        return count;
    }
}