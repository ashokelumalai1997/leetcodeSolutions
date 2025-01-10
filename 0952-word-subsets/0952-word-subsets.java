class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] tracker2 = new int[26];


        for(String word : words2) {
            int[] trackerTemp = new int[26];
            for(char ch : word.toCharArray()) {
                trackerTemp[ch - 'a']++;
            }

            for(int i = 0; i < 26; i++) {
                tracker2[i] = Math.max(tracker2[i], trackerTemp[i]);
            }
        }


        int[] tracker1  = new int[26];

        List<String> ls = new ArrayList<>();



        for(String word : words1) {
            for(char ch : word.toCharArray()) {
                tracker1[ch - 'a']++;
            }

            boolean canAdd = true;

            for(int i = 0; i < 26; i++) {
                if(tracker1[i] < tracker2[i]) {
                    canAdd = false;
                }
                tracker1[i] = 0;
            }

            if(canAdd) ls.add(word);
        }

        return ls;





        
    }
}