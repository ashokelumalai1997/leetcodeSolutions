/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {

    private int getMaxDepth(List<NestedInteger> list) {

        int childDepth = 0;

        for(NestedInteger n : list) {
            if(!n.isInteger()) {
                childDepth = Math.max(childDepth, getMaxDepth(n.getList()));
            }
        }

        return childDepth + 1;
    }

    private void getTotal(List<NestedInteger> list, 
            int maxDepth, int[] total, int currentDepth) {
        
        for(NestedInteger nt : list) {
            if(nt.isInteger()) {
                total[0] += (maxDepth - currentDepth +1)*nt.getInteger();
            } else {
                getTotal(nt.getList(), maxDepth, total, currentDepth+1);
            }
        }
    }

    public int depthSumInverse(List<NestedInteger> nestedList) {
        int maxDepth = getMaxDepth(nestedList);

        int[] total = new int[]{0};
        getTotal(nestedList, maxDepth, total, 1);
        return total[0];
    }
}