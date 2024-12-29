class Solution {
    
    
    static class CustomComparator implements Comparator<String> {
        public int compare(String a, String b) {
            return b.compareTo(a);
        }
    }
    public String answerString(String word, int numFriends) {
        int n = word.length();
        
        int maxLen = n - numFriends + 1;
        
        if(numFriends == 1) return word;
        
        List<Integer>[] arr = new ArrayList[26];
        
        for(int i = 0; i < 26; i++) {
            arr[i] = new ArrayList<>();
        }
        
        int maxInd = 0;

        String res = null;
        
        for(int i = 0; i < n; i++) {
            if(word.charAt(i) - 'a' > maxInd) {
                maxInd = word.charAt(i) - 'a';
            }
            arr[word.charAt(i) - 'a'].add(i);

            
        }
        
        
        // List<String> ls = new ArrayList<>();
        
        
        for(int ind : arr[maxInd]) {
            String current = word.substring(ind, Math.min(n, ind+maxLen));

            if(res == null || current.compareTo(res) > 0) {
                res = current;
            }
        }
        
        // Collections.sort(ls, new CustomComparator());
        
        // return ls.get(0);

        return res;
        
        
    }
}