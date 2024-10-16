class CharCountPair implements Comparable<CharCountPair> {
    Character character;
    int count;
    public CharCountPair(char character, int count) {
        this.character = character;
        this.count = count;
    }

    public int compareTo(CharCountPair cp) {
        return cp.count - this.count;
    }
}

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder result = new StringBuilder();
        PriorityQueue<CharCountPair> pq = new PriorityQueue<>();
        if(a != 0) pq.offer(new CharCountPair('a', a));
        if(c != 0) pq.offer(new CharCountPair('c', c));
        if(b != 0) pq.offer(new CharCountPair('b', b));
        while(!pq.isEmpty()) { //[a-1, b-1, c-6]
            CharCountPair currentPair = pq.poll(); //c-1
            currentPair.count--; //0
            int resultLen = result.length(); //8
            System.out.println(resultLen);
            if( resultLen >= 2 && (result.charAt(resultLen - 1) == currentPair.character)
                && (result.charAt(resultLen - 2) == currentPair.character)) { //false
                    if(pq.isEmpty()) break;
                    CharCountPair nextOnPriority = pq.poll(); //a-1
                    result.append(nextOnPriority.character); //ccbcca
                    nextOnPriority.count--; //a-0
                    if(nextOnPriority.count != 0) pq.offer(nextOnPriority);
                }
            result.append(currentPair.character); //res = 'ccbccacc'
            if(currentPair.count != 0) pq.offer(currentPair); 
        }
        return result.toString();
    }
}