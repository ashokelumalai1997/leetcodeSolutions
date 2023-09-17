class Solution {
    public boolean isAnagram(String s, String t) {
        char[] charArr = s.toCharArray();
        char[] charArr2 = t.toCharArray();
        Arrays.sort(charArr);
        Arrays.sort(charArr2);
        String n1 = new String(charArr);
        String n2 = new String(charArr2);
        if(n1.equals(n2)) return true;
        return false;
    }
}