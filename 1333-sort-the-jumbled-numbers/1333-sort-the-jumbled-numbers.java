class Solution {
    Map<Integer, Integer> mp = new HashMap<>();
     private int getMapped(int num, int[] mapping) {
        int res = 0;
        int place = 1;
        if (num == 0) return mapping[0];
        while (num > 0) {
            int digit = num % 10;
            res += mapping[digit] * place;
            place *= 10;
            num /= 10;
        }
        return res;
    }
    class CustomC implements Comparator<Integer>{
        @Override
        public int compare(Integer a, Integer b){
            int ma = mp.get(a);
            int mb = mp.get(b);
            if(ma == mb) return 0;
            return ma - mb;
        }
    }
    public int[] sortJumbled(int[] mapping, int[] nums) {
        for(int num : nums) {
            mp.put(num, getMapped(num, mapping));
        }
        Integer[] numsObj = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(numsObj, new CustomC());
        return Arrays.stream(numsObj).mapToInt(Integer::intValue).toArray();

        // 669, 007, 07
    }
}