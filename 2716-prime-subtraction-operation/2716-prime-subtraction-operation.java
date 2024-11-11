class Solution {
    private boolean isPrime(int num) {
        if(num < 2) return false;
        for(int i = 2; i*i <= num; i++) {
            if(num%i == 0) return false;
        }

        return true;
    }
    private int getLargestSubPrime(int num) {
        while(num > 0) {
            if(isPrime(num)) return num;
            num--;
        }
        return num;
    }
    public boolean primeSubOperation(int[] nums) {
        int n = nums.length;
        int[] lsp = new int[n];
        int[] res = new int[n];
        for(int i = 0; i < n; i ++) {
            int target = nums[i] - 1;
            if(i > 0) target = nums[i]-res[i-1]-1;
            int limit = 0;
            // if(i > 0) limit = res[i-1];
            // if(target <= 0) return false;
            lsp[i] = getLargestSubPrime(target);
            if(lsp[i] < 0) return false;
            res[i] = nums[i] - lsp[i];
            // if(i-1 >= 0 && res[i] <= res[i-1]) return false;
        }

        return true;

    }
}


// Input

// nums [n]

// op:
// subtract prime p from nums[i] - i shouldnt have taken before

// op - as many times as needed

// O/P:

// true if can make the array strictly increasing



// 1 2 3 4 5 6 7

// 1
// 2

// 3
// 4 -> 1+3

// 5 -> 5
// 6 -> 3+3

// 7 -> 2+5

// 20 19 18

// i -> deduct, continue

// deduct has many options - 

// for each index
//     find largest prime within nums[i] by decrementing nums[i]
//     if nums[i]-p less than res[i-1] continue otherwise quit