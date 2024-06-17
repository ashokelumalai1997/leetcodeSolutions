class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> charCount = new HashMap<>();
        for(Character ch : s.toCharArray()) {
            charCount.put(ch , charCount.getOrDefault(ch, 0)+1);
        }
        for(Character ch : t.toCharArray()) {
            if(!charCount.containsKey(ch) || charCount.get(ch) == 0) {
                return ch;
            }
            charCount.put(ch , charCount.getOrDefault(ch, 0)-1);
        }
        return 'a';
        
    }
}