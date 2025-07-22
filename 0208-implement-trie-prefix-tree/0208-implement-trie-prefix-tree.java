class Trie {
    static class Node {
            public boolean isEndOfWord;
            public Node[] children;
            
            public Node() 
            {
                this.isEndOfWord = false;
                this.children = new Node[26];
            }
        }

    Node head;
            public Trie() {
                this.head = new Node();
            }
            
            public void insert(String word) {
                Node temp = head;
                for(char ch : word.toCharArray()) {
                    if(temp.children[ch - 'a'] == null) {
                        temp.children[ch - 'a'] = new Node();
                    }
                    temp = temp.children[ch - 'a'];
                }
                temp.isEndOfWord = true;
            }
            
            public boolean search(String word) {
                Node temp = head;
                for(char ch : word.toCharArray()) {
                    if(temp.children[ch - 'a'] == null) {
                        return false;
                    }
                    temp = temp.children[ch - 'a'];
                }
                return temp.isEndOfWord;
            }
            
            public boolean startsWith(String prefix) {
                Node temp = head;
                for(char ch : prefix.toCharArray()) {
                    if(temp.children[ch - 'a'] == null) {
                        return false;
                    }
                    temp = temp.children[ch - 'a'];
                }
                return true;
            }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */