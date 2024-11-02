class Solution {
    public String reverseWords(String s) {
        int n = s.length();

        StringBuilder sbTracker = new StringBuilder();


        Deque<String> st = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == ' ') {
                if(sbTracker.length() != 0) {
                    st.offerFirst(sbTracker.toString());
                    sbTracker = new StringBuilder();
                }
                continue;
            }
            sbTracker.append(s.charAt(i));
        }

        if(sbTracker.length() != 0) st.offerFirst(sbTracker.toString());

        // StringBuilder result = new StringBuilder();

        // while(!st.isEmpty()) {
        //     String current = st.pop();
        //     result.append(current);
        //     if(!st.isEmpty()) result.append(" ");
        // }

        return String.join(" ", st);
    }
}