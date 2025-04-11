class Solution {
    public int countSymmetricIntegers(int low, int high) {
        // iterate over all integers 
        // check for evens
        // check for sum

        int count = 0;
        for(int i = low; i <= high; i++) {
            if(ok(i)) count++;
        }

        return count;
    }

    private boolean ok(Integer num) {
        char[] ch = num.toString().toCharArray();
        if(ch.length%2 != 0) return false;

        int half = ch.length/2;

        int first = 0;
        int second = 0;

        for(int i = 0; i < ch.length; i++) {
            if(i < half) first += Integer.valueOf(ch[i]);
            else second += Integer.valueOf(ch[i]);
        }

        return first == second;
    }
}