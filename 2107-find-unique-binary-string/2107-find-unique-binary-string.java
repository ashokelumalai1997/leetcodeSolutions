class Solution {
    private String findTheString(int index, StringBuilder temp, Set<String> set) {
        if(index == set.size()) {
            if(set.contains(temp.toString())) return "";
            return temp.toString();
        }

        String appendZero = findTheString(index+1, temp.append('0'), set);
        temp.deleteCharAt(temp.length()-1);
        if(!appendZero.equals("")) return appendZero;
        String appendOne = findTheString(index+1, temp.append('1'), set);
        temp.deleteCharAt(temp.length()-1);
        return appendOne;
        
    }
    public String findDifferentBinaryString(String[] nums) {
        Set<String> set = new HashSet<>();

        for(String num : nums) {
            set.add(num);
        }
        return findTheString(0, new StringBuilder(), set);
    }
}