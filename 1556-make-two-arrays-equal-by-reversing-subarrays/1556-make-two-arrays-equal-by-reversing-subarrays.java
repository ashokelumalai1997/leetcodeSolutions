class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            if(arr[i] != target[i]) return false;
        }
        return true;
    }
}