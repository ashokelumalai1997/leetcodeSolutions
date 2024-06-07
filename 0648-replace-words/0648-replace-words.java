class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> dictionarySet = new HashSet<>(dictionary);
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            StringBuilder prefix = new StringBuilder();
            boolean found = false;

            for (char c : word.toCharArray()) {
                prefix.append(c);
                if (dictionarySet.contains(prefix.toString())) {
                    result.append(prefix.toString()).append(" ");
                    found = true;
                    break;
                }
            }

            if (!found) {
                result.append(word).append(" ");
            }
        }

        // Remove the last appended space
        result.deleteCharAt(result.length() - 1);

        return result.toString();
    }
}
