class Solution {
    private int insertNum(char[] chars, int nextIndex, int num) {
        Stack<Character> st = new Stack<>();
        while(num > 9) {
            st.push(String.valueOf(num%10).charAt(0));
            num /= 10;
        }
        st.push(String.valueOf(num).charAt(0));
        while(!st.isEmpty()) {
            chars[nextIndex] = st.pop();
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