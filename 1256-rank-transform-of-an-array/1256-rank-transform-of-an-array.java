class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] arrC = new int[n];
        for(int i = 0; i < n ;i ++) arrC[i] = arr[i];
        Arrays.sort(arrC);
        Map<Integer, Integer> hm = new HashMap<>();
        int rank = 1;
        for(int i = 0; i < n; i ++) {
            if(!hm.containsKey(arrC[i])) {
                hm.put(arrC[i], rank);
                rank++;
            }
        }
        for(int i = 0; i < n; i ++) arr[i] = hm.get(arr[i]);
        return arr;
    }
}