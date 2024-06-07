class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        StringBuilder trackerWord = new StringBuilder();
        Set<String> dictionaryMap = new HashSet<>();
        for(String word : dictionary) {
            dictionaryMap.add(word);
        }
        while(i < sentence.length()){
            if(sentence.charAt(i) == ' ') {
                result.append(' ');
                trackerWord = new StringBuilder();
                i++;
                continue;
            }
            trackerWord.append(sentence.charAt(i));
            if(dictionaryMap.contains(trackerWord.toString())) {
                result.append(sentence.charAt(i));
                while(i < sentence.length() && sentence.charAt(i) != ' ') {
                    i++;
                }
            } else {
                result.append(sentence.charAt(i));
                i++;
            }
        }
        return result.toString();
    }
}