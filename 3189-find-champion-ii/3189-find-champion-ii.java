class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] arr = new int[n];
        for(int i=0;i<edges.length;i++){
            arr[edges[i][1]]++;
        }
        int count = 0;
        int pos = -1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0) {
                count++;
                pos=i;
            }
        }
        if(count==1) return pos;
        return -1;
    }
}