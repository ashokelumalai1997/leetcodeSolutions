class Solution {
    public int maximumGain(String s, int x, int y) {
        int n = s.length();
        int i = 0;
        Stack<Character> st = new Stack<>();
        char firstChar = 'b';
        char secondChar = 'a';
        int firstVal = y;
        int secondVal = x;
        int result = 0;
        int count = 0;
        if(x > y) {
            firstChar = 'a';
            secondChar = 'b';
            firstVal = x;
            secondVal = y;
        }
        while(i < n) {
            if(s.charAt(i) == secondChar) {
                if(!st.isEmpty() && st.peek() == firstChar) {
                    st.pop();
                    count++;
                    i++;
                    continue;
                }
            }
            st.push(s.charAt(i));
            i++;
        }
        result = firstVal*count;
        Stack<Character> secondSt = new Stack<>();
        i = 0;
        count = 0;
        while(!st.isEmpty()) {
            if(st.peek() == secondChar) {
                if(!secondSt.isEmpty() && secondSt.peek() == firstChar) {
                    secondSt.pop();
                    count++;
                    st.pop();
                    continue;
                }
            }
            secondSt.push(st.peek());
            st.pop();
        }
        result += count*secondVal;
        return result;
    }
}