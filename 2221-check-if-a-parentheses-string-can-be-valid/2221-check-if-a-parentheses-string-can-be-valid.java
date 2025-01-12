class Solution {
    public boolean canBeValid(String s, String locked) {
        Stack<Integer> stO = new Stack<>();
        Stack<Integer> stW = new Stack<>();

        int i = 0;
        int n = s.length();

        if(n%2 != 0) return false;

        while(i < n) {
            if(locked.charAt(i) == '0') {
                stW.push(i);
            } else if(s.charAt(i) == '(') {
                stO.push(i);
            } else {
                if(!stO.isEmpty()) {
                    stO.pop();
                } else if(!stW.isEmpty()) {
                    stW.pop();
                } else {
                    return false;
                }
            }
            i++;
        }

        while(stO.size() != 0 && stW.size() != 0 && stO.peek() < stW.peek())
        {
            stO.pop();
            stW.pop();
        }

        return stO.size() == 0;


    }
}