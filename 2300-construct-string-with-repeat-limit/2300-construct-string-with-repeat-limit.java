class Solution {

    static class CharCountPair {

        public char ch;
        public int count;
        public CharCountPair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
    public String repeatLimitedString(String s, int repeatLimit) {
        PriorityQueue<CharCountPair> q = new PriorityQueue<>(
                                (a, b) -> Character.compare(b.ch, a.ch));
        int[] charCounter = new int[26];

        for(char ch : s.toCharArray()) {
            charCounter[ch - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            if(charCounter[i] == 0) continue;
            q.offer(new CharCountPair((char)('a'+i), charCounter[i]));
        }

        StringBuilder res = new StringBuilder();

        Character current = 'a';
        int currentCount = 0;

        while(!q.isEmpty()) {
            CharCountPair ccp = q.poll();
            if(current == ccp.ch) {
                currentCount++;
            } else {
                current = ccp.ch;
                currentCount = 1;
            }

            if(currentCount > repeatLimit) {
                if(q.isEmpty()) {
                    break;
                } else {
                    CharCountPair secondCh = q.poll();
                    res.append(secondCh.ch);
                    current = secondCh.ch;
                    currentCount = 1;
                    secondCh.count--;
                    if(secondCh.count != 0) {
                        q.offer(secondCh);
                    }
                    q.offer(ccp);
                    continue;
                }
            }
            res.append(ccp.ch);
            ccp.count--;
            if(ccp.count != 0) q.offer(ccp);
        }

        return res.toString();


    }
}