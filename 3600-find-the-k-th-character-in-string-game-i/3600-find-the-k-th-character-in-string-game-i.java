class Solution {
    public char kthCharacter(int k) {
        int i = 1;
        char res = 'a';
        if(k == 1) return res;
        StringBuilder sb = new StringBuilder("a");
        
        while(i < k) {
            int l = sb.length();
            int j = 0;
            while(j < l) {
                
                
                char currentChar = sb.charAt(j);
                char nextChar = currentChar == 'z' ? 'a' : (char)(currentChar+1);
                sb.append(nextChar);
                i++;
                j++;
                if(i == k) {
                    res = nextChar;
                    break;
                }
            }
        }
        return res;
    }
}