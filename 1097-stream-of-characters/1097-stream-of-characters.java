
class Trie {
    static class TrieNode {
        boolean isEndOfWord;
        TrieNode[] children = new TrieNode[26];

        public TrieNode() {
            isEndOfWord = false;
            for(int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public boolean checkSuffix(List<Character> chars) {
            TrieNode temp = root;
            int n = chars.size();
            for(int i = n-1; i >= 0; i--) {
                if(temp.isEndOfWord) return true;
                if(temp.children[chars.get(i) - 'a'] == null) return false;
                temp = temp.children[chars.get(i) - 'a'];
            }
            return temp.isEndOfWord;
        }

        public void insertWord(String s) {
            TrieNode temp = root;
            int n = s.length();
            for(int i = n-1; i >= 0; i--) {
                if(temp.children[s.charAt(i) - 'a'] == null) {
                    temp.children[s.charAt(i) - 'a'] = new TrieNode();
                }
                temp = temp.children[s.charAt(i) - 'a'];
            }
            temp.isEndOfWord = true;
        }
}



class StreamChecker {

    Trie trie;

    List<Character> chars;

    public StreamChecker(String[] words) {
        this.trie = new Trie();
        for(String w : words) {
            trie.insertWord(w);
        }
        this.chars = new ArrayList<>();
    }
    
    public boolean query(char letter) {
        this.chars.add(letter);
        return trie.checkSuffix(chars);
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */