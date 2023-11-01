class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int p1=0;
        int p2=0;
        int l = (l1+l2)/2;
        Integer prev=null;
        Integer ele = null;
        int n=0;
        System.out.println(l);
        while(n!=l+1){
            Integer el=null;
            if(p1>=l1){
                el=nums2[p2];
                p2++;
                
            } else if(p2>=l2){
                el=nums1[p1];
                p1++;
            } else {
                if(nums1[p1]<=nums2[p2]){
                    el=nums1[p1];
                    p1++;
                } else {
                    el=nums2[p2];
                    p2++;
                }
            }
            prev=ele;
            ele=el;
            n++;
            
        }
        System.out.println(ele);
        System.out.println(prev);
        if((l1+l2)%2==0){
            return (double)(prev+ele)/2;
        }
        return ele;
    }
}