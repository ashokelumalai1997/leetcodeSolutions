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
        int totalPairs = st.size()/2;
        return  totalPairs/2 + totalPairs%2;
    }
}