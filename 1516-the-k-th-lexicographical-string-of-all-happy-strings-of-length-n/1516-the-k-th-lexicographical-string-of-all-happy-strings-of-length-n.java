class Solution {
    private void getStrings(int ind, int n, StringBuilder temp, List<String> strList) {
        if(ind == n) {
            strList.add(temp.toString());
            return;
        }

        Character[] chars = new Character[]{'a','b','c'};

        for(char ch : chars) {
            if(ind == 0 || temp.charAt(ind-1) != ch) {
                getStrings(ind+1, n, temp.append(ch), strList);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }
    public String getHappyString(int n, int k) {
        List<String> strList = new ArrayList<>();
        getStrings(0, n, new StringBuilder(), strList);
        if(strList.size() < k) return "";
        Collections.sort(strList);
        return strList.get(k-1);
    }
}