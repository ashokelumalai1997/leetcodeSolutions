class Solution {
    public int maxFreqSum(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int[] count = new int[26];

        int maxVow = 0;

        int maxCons = 0;

        for(char ch : s.toCharArray()) {
            count[ch - 'a']++;
            if(vowels.contains(ch)) {
                maxVow = Math.max(maxVow, count[ch - 'a']);
            } else {
                maxCons = Math.max(maxCons, count[ch - 'a']);
            }
        }

        return maxVow + maxCons;
    }
}