class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        int i = 0;
        int n = s.length();
        while(i < n) {
            if(s.charAt(i) != ')') {
                st.push(s.charAt(i));
            } else {
                Queue<Character> q = new LinkedList<>();
                while(st.peek() != '(') {
                    q.offer(st.pop());
                }
                st.pop();
                while(!q.isEmpty()) st.push(q.poll());
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.empty()) {
            sb = sb.insert(0, st.pop());
        }
        return sb.toString();
    }
}