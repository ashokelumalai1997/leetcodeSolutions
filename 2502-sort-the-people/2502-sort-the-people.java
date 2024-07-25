class Solution {
    class Pair implements Comparable<Pair>{
        String name;
        int heights;
        public Pair(String name, int heights){
            this.name = name;
            this.heights = heights;
        }

        @Override
        public int compareTo(Pair p) {
            return p.heights - this.heights;
        }
    }
    public String[] sortPeople(String[] names, int[] heights) {
        List<Pair> list = new ArrayList<>();
        int n = names.length;
        for(int i = 0; i < n; i++) {
            list.add(new Pair(names[i], heights[i]));
        }
        Collections.sort(list);
        String[] namesOut = new String[n];
        for(int i = 0; i < n; i++) {
            namesOut[i] = list.get(i).name;
        }
        return namesOut;
    }
}