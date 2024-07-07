class Solution {
    public List<String> validStrings(int n) {
        List<String> result1 = new ArrayList<>();
        int ind = 1;
        result1.add("0");
        result1.add("1");
        if(n == 1) return result1;
        String currentString = null;
        List<String> re = new ArrayList<>();
        while(ind < n) {
            List<String> result = new ArrayList<>();
            for(int i = 0; i < result1.size();i++) {
                currentString = result1.get(i);
                
                if(currentString.charAt(ind - 1) == '1') {
                    result.add(currentString + "0");
                    result.add(currentString + "1");
                    if(ind == n -1) {
                        re.add(currentString + "0");
                        re.add(currentString + "1");
                    }
                } else {
                    result.add(currentString + "1");
                    if(ind == n -1) re.add(currentString + "1");
                }
            }
            result1 = result;
            ind++;
        }
        return re;
    }
}