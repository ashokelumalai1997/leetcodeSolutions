class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int n3 = arr3.length;
        int n = Math.max(arr1[n1-1], arr2[n2-1]);
        n = Math.max(n, arr3[n3-1]);
        int[] tracker = new int[n+1]; 
        for(int i = 0; i < n1; i++) {
            tracker[arr1[i]]++;
        }
        
        for(int i = 0; i < n2; i++) {
            tracker[arr2[i]]++;
        }

        for(int i = 0; i < n3; i++) {
            tracker[arr3[i]]++;
        }

        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < n+1; i++) {
            if(tracker[i] == 3) {
                res.add(i);
            }
        }

        return res;
    }
}