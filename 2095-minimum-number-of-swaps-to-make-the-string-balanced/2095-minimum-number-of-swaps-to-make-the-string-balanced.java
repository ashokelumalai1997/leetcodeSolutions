class Solution {
    public int minSwaps(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()) {
            if(ch == ']' && !st.isEmpty() && st.peek() == '[') {
                st.pop();
                continue;
            }
            st.push(ch);
        }
        return st.size()/4 + (st.size()/2)%2;
    }
}