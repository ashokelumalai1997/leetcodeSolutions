import java.util.*;

class Solution {
    public List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) return result;
        if (n == 1) {
            result.add("0");
            result.add("1");
            return result;
        }
        
        List<String> prev = new ArrayList<>();
        prev.add("0");
        prev.add("1");

        for (int ind = 2; ind <= n; ind++) {
            List<String> current = new ArrayList<>();
            for (String str : prev) {
                if (str.charAt(str.length() - 1) == '1') {
                    current.add(str + "0");
                    current.add(str + "1");
                } else {
                    current.add(str + "1");
                }
            }
            prev = current;
        }

        return prev;
    }
}
