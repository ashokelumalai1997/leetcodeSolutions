// sort the nums
// for every index
//     if index == prevind continue
//     target becomes -nums[index]
//     left = next index
//     right = end
//     while(left < right) {
//         if(left + right == 0) add them to the q. move dups
//         if left+right > 0 right--
//         else left--
//     }
// [-4, -1, -1, 0, 1, 2]
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < n; i ++) {
            if(i-1 >=0 && nums[i-1] == nums[i]) continue;
            int target = -1*nums[i];
            int left = i+1;
            int right = n-1;
            while(left < right) {
                if(left-1 != i && nums[left] == nums[left-1]) {
                    left++;
                    continue;
                }
                if(nums[left] + nums[right] == target) {
                    List<Integer> newEntry = new ArrayList<>();
                    newEntry.add(nums[i]);
                    newEntry.add(nums[left]);
                    newEntry.add(nums[right]);
                    res.add(newEntry);
                    // while(left+1 < n && nums[left] == nums[left+1]) left++;                  
                    left++;
                } else if(nums[left] + nums[right] > target) {
                    right--;
                } else {
                    left++;
                }
                // while(left < n-1 && nums[left - 1] == nums[left]) left++;
            }
            // while()
        }
        return res;
    }
}


// for every index
//  use a hashmap
//  target becomes target - nums[index]
//  from next index
//    check if current - new target is in hm
//    yes : add nums[i], current-new target, current to the list




