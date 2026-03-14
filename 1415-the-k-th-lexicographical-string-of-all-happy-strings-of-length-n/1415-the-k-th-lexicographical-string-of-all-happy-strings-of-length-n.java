class Solution {
    public String getHappyString(int n, int k) {
        List<String> strings = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        getStrings(strings, 0, temp, n);
        Collections.sort(strings);
        if(k > strings.size()) return "";
        return strings.get(k - 1);
    }

    private void getStrings(List<String> list, int ind, StringBuilder temp, int n) {
        if(ind == n) {
            list.add(temp.toString());
            return;
        }
        Character[] options = new Character[]{'a', 'b', 'c'};
        for(Character ch : options) {
            if(ind == 0 || temp.charAt(ind - 1) != ch) {
                temp.append(ch);
                getStrings(list, ind+1, temp, n);
                temp.deleteCharAt(ind);
            }
        }
    }
}