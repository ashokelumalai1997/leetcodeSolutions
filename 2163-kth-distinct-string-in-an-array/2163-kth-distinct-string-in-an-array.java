class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> m = new HashMap<>();
        int n = arr.length;
        int[] flag = new int[n];
        for(int i = 0; i < n; i ++) {
            if(m.containsKey(arr[i])) {
                flag[m.get(arr[i])] = 1;
                flag[i] = 1;
            } else {
                m.put(arr[i], i);
            }
        }
        int i = 0;
        String res = "";
        while(i < n && k > 0) {
            if(k == 1 && flag[i] == 0) {
                res = arr[i];
            }
            if(flag[i] == 0)k--;
            i++;
        }
        return res;
    }
}