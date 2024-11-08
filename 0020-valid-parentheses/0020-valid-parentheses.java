class Solution {

    private Character getMatch(Character c) {
        if(c == '}') return '{';
        if(c == ')') return '(';
        return '[';
    }
    
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '{'
                || s.charAt(i) == '['
                || s.charAt(i) == '(') {
            st.push(s.charAt(i));
            } else {
                if(!st.isEmpty() 
                    && st.peek() == getMatch(s.charAt(i))) {
                    st.pop();
                } else {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }
}

// { [ ( -> push into stack

// } ) ] -> top should match and not empty

// finally stack should be empty

