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


    private int getVal(List<NestedInteger> ni, int weight) {
        
        int total = 0;
        // if(ni.isInteger()) return ni.getInteger();
        for(NestedInteger nt : ni) {
            if(nt.isInteger()) total += nt.getInteger()*weight;
            else total += getVal(nt.getList(), weight+1);
        }

        return total;
    }
    public int depthSum(List<NestedInteger> nestedList) {

        int total = 0; 
        for(NestedInteger nt : nestedList) {
            if(nt.isInteger()) total += nt.getInteger();
            else total += getVal(nt.getList(), 2);
        }

        return total;
    }
}