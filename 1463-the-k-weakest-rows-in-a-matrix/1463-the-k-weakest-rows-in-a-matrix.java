class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] result = new int[k];
        int[] temp = new int[mat.length];
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(k,(a,b)->{if(b.get(0)==a.get(0)) return a.get(1)-b.get(1);else return a.get(0)-b.get(0);});
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                temp[i]+=mat[i][j];
            }
        }
        for(int i=0;i<mat.length;i++){
            List<Integer> t = new ArrayList<Integer>();
            t.add(temp[i]);
            t.add(i);
            pq.offer(t);
        }
        for(int i=0;i<k;i++){
            int t = pq.peek().get(1);
            pq.remove();
            result[i]=t;
        }
        return result;
    }
}