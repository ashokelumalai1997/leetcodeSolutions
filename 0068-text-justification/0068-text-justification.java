class Solution {
    private void fixLine(StringBuilder line, List<StringBuilder> words, int maxWidth, boolean lastLine){
        int remainingWidth = maxWidth - line.length();
        if(words.isEmpty()) {
            while(line.length() < maxWidth) {
                // maxWidth--;
                line.append(" ");
            }
            return;
        }
        
        for(StringBuilder word : words) {
            remainingWidth -= word.length();
        }
        int i = 0;
        if(lastLine) 
        {
            while(remainingWidth > 0) {
                remainingWidth--;
                words.get(words.size() - 1).append(" ");
            }
        } else {
            while(remainingWidth > 0) {
                remainingWidth--;
                i = (i)%(words.size());
                words.get(i).insert(0, " ");
                i++;
            }
        }
        
        for(StringBuilder sb : words) {
            line.append(sb.toString());
        }
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        int wordPointer = 0;
        int n = words.length;
        List<String> result = new ArrayList<>();
        while(wordPointer < n) {

            StringBuilder newLine = new StringBuilder(words[wordPointer]);
            wordPointer++;
            List<StringBuilder> wordsToAppend = new ArrayList<>();
            int currentLineLength = newLine.length();
            while(wordPointer < n && (currentLineLength + 1 + words[wordPointer].length()) <= maxWidth) {
                currentLineLength += 1 + words[wordPointer].length();
                wordsToAppend.add(new StringBuilder(" " + words[wordPointer]));
                wordPointer++;
            }
            fixLine(newLine, wordsToAppend, maxWidth, wordPointer == n);
            result.add(newLine.toString());
        }
        return result;
    }
}