class Solution {
    static class Trie {
        static class TrieNode {
            TrieNode[] child;
            boolean isEndOfWord;
            public TrieNode() {
                child = new TrieNode[26];
                for(int i = 0; i < 26; i++) {
                    child[i] = null;
                }
                isEndOfWord = false;
            }
        }

        private TrieNode head;

        public Trie() {
            head = new TrieNode();
        }

        public void addWord(String word) {
                char[] wordChars = word.toCharArray();

                TrieNode temp = head;

                for(char ch : wordChars) {
                    if(temp.child[ch - 'a'] == null) {
                        temp.child[ch - 'a'] = new TrieNode();
                    }
                    temp = temp.child[ch - 'a'];
                }

                temp.isEndOfWord = true;
        }

        public TrieNode getRef() {
            return head;
        }
    }

    private boolean isPossible(int[] breakMemo, int i, String s, Trie trie, Trie.TrieNode trieNode) {
        

        if(trieNode.child[s.charAt(i) - 'a'] == null) return false;

        boolean breakoption = false;

        if(i+1 == s.length()) {
            return trieNode.child[s.charAt(i) - 'a'].isEndOfWord;
        }

        if(trieNode.child[s.charAt(i) - 'a'].isEndOfWord) {
            if(breakMemo[i+1] != -1) breakoption = breakMemo[i+1] != 0;
            else {
                
                breakoption = isPossible(breakMemo, i+1, s, trie, trie.getRef());
                breakMemo[i+1] = breakoption ? 1 : 0;
            };
        }

        boolean contOption = false;

        contOption = isPossible(breakMemo, i+1, s, trie, trieNode.child[s.charAt(i) - 'a']);


        return breakoption || contOption;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();

        for(String word : wordDict) {
            trie.addWord(word);
        }

        int[] breakMemo = new int[s.length()];

        Arrays.fill(breakMemo, -1);

        return isPossible(breakMemo, 0, s, trie, trie.getRef());

    }
}