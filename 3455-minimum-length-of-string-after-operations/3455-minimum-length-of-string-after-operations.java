class Solution {
    public int minimumLength(String s) {
        int[] counter = new int[26];
        for(char ch : s.toCharArray()) {
            counter[ch - 'a']++;
        }

        int result = 0;

        for(int i = 0; i < 26; i++) {
            if(counter[i] == 0) continue;
            if(counter[i]%2 == 0) result+=2;
            else result += 1;
        }

        return result;
    }
}