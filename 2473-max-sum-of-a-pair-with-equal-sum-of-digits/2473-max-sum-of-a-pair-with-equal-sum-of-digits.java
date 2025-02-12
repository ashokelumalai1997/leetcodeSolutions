class Solution {

    private int getSingleDigit(int num) {
        int res = 0;

        while(num > 0) {
            res += num%10;
            num /= 10;
        }

        return res;

        // return getSingleDigit(res);
    }
    public int maximumSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int n = nums.length;


        int result = -1;


        for(int i = 0; i < n; i++) {
            int num = nums[i];

            int digit =  getSingleDigit(num);

            if(map.containsKey(digit)) {
                result = Math.max(result, map.get(digit) + num);
                map.put(digit, Math.max(num, map.get(digit)));
            } else {
                map.put(digit, num);
            }
        }

        return result;




    }
}


