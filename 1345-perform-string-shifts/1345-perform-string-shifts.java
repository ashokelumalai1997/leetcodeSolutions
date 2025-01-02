class Solution {
    public String stringShift(String s, int[][] shift) {
        int shifts = 0;
        for(int[] sf : shift) {
            if(sf[0] == 0) {
                shifts -= sf[1];
            } else {
                shifts += sf[1];
            }
        }

        

        if(shifts == 0) return s;

        int n = s.length();

        shifts %= n;

        if(shifts < 0) {
            shifts = n + shifts;
        }

        char[] res = new char[n];

        for(int i = 0; i < n; i++) {
            res[(i+shifts)%n] = s.charAt(i);
        }


        return new String(res);

    }
}