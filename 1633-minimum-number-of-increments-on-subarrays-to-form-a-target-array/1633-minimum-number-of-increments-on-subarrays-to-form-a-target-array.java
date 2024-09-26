class Solution {
    public int minNumberOperations(int[] target) {
        int result = 0;
        int n = target.length;
        int prev = 0;
        for(int i = 0; i < n; i++) {
            if(prev < target[i]) {
                result += target[i] - prev;
            }
            prev = target[i];
        }
        return result;
    }
}

// 3  1  5  4  2
// 1. 1. 1. 1. 1
// 1.    1. 1. 1
// 1.    1. 1. 
//       1. 1    
//       1.    