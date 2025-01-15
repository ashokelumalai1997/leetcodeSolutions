class Solution {
    public int minimizeXor(int num1, int num2) {
        int x = num1;

        int count1 = 0;

        while(num2 > 0) {
            count1 += ((num2 & 1) == 0) ? 0 : 1;
            num2 = (num2 >> 1);
        }

        int tracker = 30;

        while(tracker >= 0) {
            int bitVal = (x & (1 << tracker));
            if(bitVal != 0) {
                if(count1 > 0) {
                    count1--;
                } else {
                    x = x&(~(1 << tracker));
                }
            }
            tracker--;
        }

        tracker = 0;

        while(count1 > 0) {
            if((x&(1 << tracker)) == 0) {
                x = x|(1 << tracker);
                count1--;
            }
            tracker++;
        }

        return x;
    }
}

// Given :
// num1 
// num2 

// to find : x

// condition : x XOR num1 should be minimal with x having only number of set bits in num2

// find set bits in num2

// to make x minimal, x should have set bits on all the places num2 has set bits