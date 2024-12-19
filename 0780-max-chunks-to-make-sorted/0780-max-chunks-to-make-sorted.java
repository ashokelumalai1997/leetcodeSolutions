class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;


        int[] tracker = new int[n];

        int parts = 0;


        for(int i = 0; i < n; i++) {
            tracker[arr[i]]++;
            boolean found = true;
            for(int j = 0; j <= i; j++) {
                if(tracker[j] == 0) {
                    found = false;
                    break;
                }
            }
            if(found) parts++;
        }

        return parts;
    }
}