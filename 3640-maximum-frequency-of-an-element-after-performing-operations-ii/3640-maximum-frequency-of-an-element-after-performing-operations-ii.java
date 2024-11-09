class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Map<Integer, Integer> intervalSpace = new HashMap<>();
        Set<Integer> st = new TreeSet<>();
        Map<Integer, Integer> freqSpace = new HashMap<>();
        for(int num : nums) {
            freqSpace.put(num, freqSpace.getOrDefault(num, 0)+1);
            // intervalSpace.put(num, intervalSpace.getOrDefault(num, 0));
            
            intervalSpace.put(num-k, intervalSpace.getOrDefault(num-k, 0)+1);
            intervalSpace.put(num+k+1, intervalSpace.getOrDefault(num+k+1, 0)-1);

            st.add(num);
            st.add(num-k);
            st.add(num+k+1);
        }
        int maxFreq = 0;

        int sum = 0;

        for(int key : st) {
            int value = intervalSpace.getOrDefault(key, 0);
            sum += value;
            int count = freqSpace.getOrDefault(key, 0);
            int freq = Math.min(sum-count, numOperations);
            maxFreq = Math.max(maxFreq, count+freq);
        }

        return maxFreq;
    }
}

// 0  5.       10- 
//        6         11.      16-
//               15      20.      25-
//               15      20.      25-
