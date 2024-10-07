class Solution {
    public int minLength(String s) {
        char[] sArr = s.toCharArray();
        Stack<Character> q = new Stack<>();
        int n = s.length();
        for(int i = 0; i < n; i++) {
            if(q.size() != 0 && sArr[i] == 'B') {
                Character top = q.peek();
                if(top == 'A') q.pop();
                else q.push(sArr[i]);
            } else if(q.size() != 0 && sArr[i] == 'D') {
                Character top = q.peek();
                if(top == 'C') q.pop();
                else q.push(sArr[i]);
            } else {
                q.push(sArr[i]);
            }
        }
        return q.size();
    }
}