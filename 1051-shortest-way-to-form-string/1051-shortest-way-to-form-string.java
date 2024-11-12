class Solution {
    public int shortestWay(String source, String target) {
        int m = source.length();
        int n = target.length();
        int[][] posTracker = new int[m][26];
        // for(int i = 0; i < m; i ++ ) {
            for( int j = 0; j < 26; j++) {
                posTracker[m-1][j] = m;
            }
        // }

        posTracker[m-1][source.charAt(m-1) - 'a'] = m-1;
        for(int i = m-2; i >= 0; i -- ) {
            for( int j = 0; j < 26; j++) {
                posTracker[i][j] = posTracker[i+1][j];
            }
            posTracker[i][source.charAt(i) - 'a'] = i;
        }

        int sp = 0; 
        int tp = 0;

        int res = 0;

        while(tp < n) {
            if(sp == 0) res++;
            if(source.charAt(sp) == target.charAt(tp)) {
                sp++;
                // sp %= m;
                tp++;
            } else {
                sp = posTracker[sp][target.charAt(tp) - 'a'];
                
            }

            if(sp == m) {
                if(tp == n) break;
                if(posTracker[0][target.charAt(tp) - 'a'] != m) {
                    sp = 0;
                } else {
                    return -1;
                }
            }
            
        }

        return res;


    }
}


