class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> st = new HashSet<>();
        for(Character ch : allowed.toCharArray()) st.add(ch);
        int count = words.length;
        for(String word : words) {
            for(Character ch : word.toCharArray()) {
                if(!st.contains(ch)) {
                    count--;
                    break;
                }
            }
        }
        return count;
    }
}