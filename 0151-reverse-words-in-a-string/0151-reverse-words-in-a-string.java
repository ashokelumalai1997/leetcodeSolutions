class Solution {
    public String reverseWords(String s) {
        int n = s.length();

        StringBuilder sbTracker = new StringBuilder();


        Stack<String> st = new Stack<>();

        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == ' ') {
                if(sbTracker.length() != 0) {
                    st.push(sbTracker.toString());
                    sbTracker = new StringBuilder();
                }
                continue;
            }
            sbTracker.append(s.charAt(i));
        }

        if(sbTracker.length() != 0) st.push(sbTracker.toString());

        StringBuilder result = new StringBuilder();

        while(!st.isEmpty()) {
            String current = st.pop();
            result.append(current);
            if(!st.isEmpty()) result.append(" ");
        }

        return result.toString();
    }
}