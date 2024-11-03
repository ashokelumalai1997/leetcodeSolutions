class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        String n = goal + goal;
        return n.contains(s);
    }
}