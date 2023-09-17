class Solution {
    public int mostWordsFound(String[] sentences) {
        int countMax = 0;
        for(String s:sentences){
            int l = s.split(" ").length;
            countMax=Math.max(countMax,l);
        }
        return countMax;
    }
}