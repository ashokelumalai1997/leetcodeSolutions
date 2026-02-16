class Solution {
    public int minAddToMakeValid(String s) {
        int res = 0;
        if(s.equals("")) return res;

        Stack<Character> st = new Stack<>();

        for(Character ch : s.toCharArray()) {
            if((ch == ')') && !st.isEmpty() && (st.peek() == '(')){
                st.pop();
            } else {
                st.push(ch);
            }
        }

        return st.size();
    }
}