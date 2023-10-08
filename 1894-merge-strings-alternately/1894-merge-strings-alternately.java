class Solution {
    public String mergeAlternately(String word1, String word2) {
        String result="";
        int l1=word1.length();
        int l2=word2.length();
        int i=0;
        int j=0;
        while(i<l1||j<l2){
            if(i<l1){
                result+=word1.charAt(i);
                i++;
            }
            if(j<l2){
                result+=word2.charAt(j);
                j++;
            }
        }
        return result;
    }
}