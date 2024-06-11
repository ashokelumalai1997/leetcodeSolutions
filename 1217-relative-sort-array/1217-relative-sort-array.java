
class Solution {
    private class Pair implements Comparable<Pair>{
        public int index;
        public int val;

        public Pair(int index, int val){
            this.index = index;
            this.val = val;
        }

        @Override
        public int compareTo(Pair a){
            if(this.index != -1 && a.index != -1) return this.index - a.index;
            else if(this.index != -1) return -1;
            else if(a.index != -1) return 1;
            else return this.val - a.val;
        }
    }
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for(int i = 0; i < arr2.length; i ++) {
            indexMap.put(arr2[i], i);
        }
        List<Pair> listOfPairs = new ArrayList<>();
        for(int i = 0; i < arr1.length; i ++) {
            listOfPairs.add(new Pair(indexMap.getOrDefault(arr1[i], -1), arr1[i]));
        }
        Collections.sort(listOfPairs);
        int[] result = new int[arr1.length];
        int i = 0;
        for(Pair p : listOfPairs) {
            result[i] = p.val;
            i++;
        }
        return result;
    }
}