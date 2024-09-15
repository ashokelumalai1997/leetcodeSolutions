class Solution {
    public int findTheLongestSubstring(String s) {
        int mask = 0;
        mask |= (1<<0);
        mask |= (1<<1);
        mask |= (1<<2);
        mask |= (1<<3);
        mask |= (1<<4);
        int[] maskTracker = new int[(int)Math.pow(2,5)];
        Arrays.fill(maskTracker, -2);
        maskTracker[mask] = -1;
        int[] counter = new int[26];
        int n = s.length();
        int res = 0;
        for(int i = 0; i <n ;i++) {
            counter[s.charAt(i) - 'a']++;
            int currentMask = 0;
            if(counter[0]%2 == 0) currentMask |= (1<<0);
            if(counter[4]%2 == 0) currentMask |= (1<<1);
            if(counter[8]%2 == 0) currentMask |= (1<<2);
            if(counter[14]%2 == 0) currentMask |= (1<<3);
            if(counter[20]%2 == 0) currentMask |= (1<<4);
            if(currentMask == (Math.pow(2,5)-1)) res = i+1;
            else {
                if(maskTracker[currentMask] != -2) {
                    res = Math.max(res, i-maskTracker[currentMask]);
                } else {
                    maskTracker[currentMask] = i;
                }
            }
            
        }
        return res;
    }
}

/*

dhasiuefbcojobkjasdkbj

a e i o u
0 0 0 0 0

n^2

even - even = even

odd - odd = even

odd - even = odd

i......j


a@j == even 
e@j == even
i@j == even
o@j == even
u@j == odd

*/