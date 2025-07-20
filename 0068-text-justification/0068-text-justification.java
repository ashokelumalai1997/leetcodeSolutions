class Solution {
    public void fixLine(List<StringBuilder> line, int currentLineLength, boolean isLast, int maxWidth) {
        int rem = maxWidth - currentLineLength;
        
        int lineWords = line.size();
        
        int i = 1;
        
        while(i < lineWords) {
            line.set(i, line.get(i).insert(0,  ' '));
            i++;
        }
        
        i = 1;
        
        if(isLast || line.size() == 1) {
            while(rem > 0) {
                line.get(line.size() - 1).append(" ");
                rem--;
            }
            return;
        }

        int index = 0;
        
        while(rem > 0) {
            if(index%line.size() == 0) {
                index++; 
                continue;
            }
            line.set(index%line.size(), line.get(index%line.size()).insert(0, ' '));
            index++;
            rem--;
        }
        
    }
    
    public String getSentence(List<StringBuilder> words) {
        StringBuilder sb = new StringBuilder();
        
        for(StringBuilder word : words) {
            sb.append(word);
        }
        
        return sb.toString();
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        
        int wordPointer = 0;
        
        int n = words.length;
        
        List<String> para = new ArrayList<>();
        
        while(wordPointer < n) {
            int currentLineLength = words[wordPointer].length();
            List<StringBuilder> currentLine = new ArrayList<>();
            currentLine.add(new StringBuilder(words[wordPointer]));
            wordPointer++;
            while(wordPointer < n && currentLineLength + 1 + words[wordPointer].length() <= maxWidth) {
                currentLine.add(new StringBuilder(words[wordPointer]));
                currentLineLength += (words[wordPointer].length());
                if(currentLine.size() != 1) currentLineLength++;
                wordPointer++;
            }
            boolean isLast = (wordPointer == n) ? true : false;
            fixLine(currentLine, currentLineLength, isLast, maxWidth);
            String sentence = getSentence(currentLine);
            para.add(sentence);
        } 
        
        return para;
    }
}