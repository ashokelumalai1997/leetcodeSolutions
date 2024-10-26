class Solution {
    private int insertNum(char[] chars, int nextIndex, int num) {
        String numStr = String.valueOf(num);
        char[] numCh = numStr.toCharArray();
        for(char ch : numCh) {
            chars[nextIndex] = ch;
            nextIndex++;
        }
        return nextIndex;
    }
    public int compress(char[] chars) {
        int n = chars.length;
        int nextIndex = 0;
        for(int i = 0; i < n; i++) {
            int count = 0;
            chars[nextIndex] = chars[i];
            nextIndex++;
            while(i+1 < n && chars[i+1] == chars[i]) {
                count++;
                i++;
            }
            if(count != 0) 
                nextIndex = insertNum(chars, nextIndex, count+1);
            // else nextIndex++;
        }
        return nextIndex;
    }
}