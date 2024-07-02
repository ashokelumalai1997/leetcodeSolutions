class Solution {
    private int[] getIntersection(int[] largeArray, int[] smallArray){
        List<Integer> list = new ArrayList<>();
        int[] map = new int[1001];
        for(int num : smallArray) {
            map[num]++;
        }
        for(int num : largeArray) {
            if(map[num] != 0) {
                list.add(num);
                map[num]--;
            }
            
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length < nums2.length) return getIntersection(nums2, nums1);
        return getIntersection(nums1, nums2);
    }
}