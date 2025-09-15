class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        
        char[] chars = brokenLetters.toCharArray();
        String[] words = text.split(" ");
        int count = words.length;
        for(String word : words) {
            for(char ch : chars) {
                if(word.indexOf(ch) != -1) {
                    count--;
                    break;
                }
            }
        }

        return count;
    }
}