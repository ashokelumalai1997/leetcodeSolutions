class Solution {
    private void findAllSubsets(List<Integer> numsList, int index, List<Integer> tempList, List<List<Integer>> result){
        //if(index==numsList.size()){
            result.add(new ArrayList<>(tempList));
          //  return;
        //}
        for(int i=index; i<numsList.size();i++){
            tempList.add(numsList.get(i));
            findAllSubsets(numsList, i+1, tempList, result);
            tempList.remove(tempList.size()-1);
            //findAllSubsets(numsList, i+1, tempList, result);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numsList = new ArrayList<>();
        for(int num:nums){
            numsList.add(num);
        }
        List<Integer> tempList = new ArrayList<>();
        findAllSubsets(numsList, 0, tempList, result);
        return result;
    }
}