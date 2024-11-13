class Solution {
    /*
    sort the array

for every index, 
    find position where it can reach lower only on the left
    find position where it can reach higher only on the left
    add right - left + 1 to the answer
    */
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);

        int n = nums.length;

        long res = 0;

        for(int i = 0; i < n; i++) {
            int minL = lower - nums[i];
            int leftInd = getMinIndex(nums, 0, i-1, minL);
            int maxL = upper - nums[i];
            int rightInd = getMaxIndex(nums, 0, i-1, maxL);
            if(leftInd != -1 && rightInd >= leftInd) {
                res += (rightInd - leftInd + 1);
            }
        }

        return res;
    }

    /*
    track index = -1;
till left <= right
if mid is less than at least, go right
else go left (track index)
    */

    private int getMinIndex(int[] nums, int left, int right, int limit) {
        // int left = 0;
        // int right = nums.length - 1;
        
        int ind = -1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] < limit) {
                
                left = mid+1;
            } else {
                ind = mid;
                right = mid-1;
            }
        }

        return ind;
    }


    /*

track index = -1;
till left <= right
if mid is less than or equal to max, go right (track index)
else go left (track index)
    */

    private int getMaxIndex(int[] nums, int left, int right, int limit) {
        // int left = 0;
        // int right = nums.length - 1;
        int ind = -1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] <= limit) {
                ind = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        return ind;
    }


}


// sort the array

// for every index, 
//     find position where it can reach lower only on the left
//     find position where it can reach higher only on the left
//     add right - left + 1 to the answer


// find position where it can reach lower only on the left

// at least - (lower - current)

// track index = -1;
// till left <= right
// if mid is less than at least, go right
// else go left (track index)

// max - (higher - current)

// track index = -1;
// till left <= right
// if mid is less than or equal to max, go right (track index)
// else go left (track index)

// 0 1 7 4 4 5


// -2 -1 0 1 (3) 4 4 (6) 5 7



// -2 -> 5 till 8
// -1 -> 4 till 7

// 0 -> 3 till 6
// 1 -> 2 till 5
// 3 -> 0 till 3
// 4 -> -1 till 2
