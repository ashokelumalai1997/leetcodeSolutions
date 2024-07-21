class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] rowIndex = new int[k+1];
        int[] colIndex = new int[k+1];
        Map<Integer, List<Integer>> rowGraph = new HashMap<>();
        Map<Integer, List<Integer>> colGraph = new HashMap<>();
        for(int i = 1; i <= k; i++) {
            rowGraph.put(i, new ArrayList<>());
            colGraph.put(i, new ArrayList<>());
        }
        int[] inDegreeRows = new int[k+1];
        for(int i = 0; i < rowConditions.length; i++) {
            rowGraph.get(rowConditions[i][0]).add(rowConditions[i][1]);
            inDegreeRows[rowConditions[i][1]]++;
        }
        int[] inDegreeCols = new int[k+1];
        for(int i = 0; i < colConditions.length; i++) {
            colGraph.get(colConditions[i][0]).add(colConditions[i][1]);
            inDegreeCols[colConditions[i][1]]++;
        }
        Queue<Integer> qR = new LinkedList<>();
        for(int i = 1; i <= k; i++){
            if(inDegreeRows[i] == 0) {
                qR.offer(i);
            }
        }
        int rowInd = 0;
        while(!qR.isEmpty() && rowInd < k) {
            int current = qR.poll();
            rowIndex[current] = rowInd;
            for(int node : rowGraph.get(current)) {
                inDegreeRows[node]--;
                if(inDegreeRows[node] == 0) qR.offer(node);
            }
            rowInd++;
        }
        for(int i = 1; i <= k; i++) {
            if(inDegreeRows[i] != 0) return new int[][]{};
        }

        Queue<Integer> qC = new LinkedList<>();
        for(int i = 1; i <= k; i++){
            if(inDegreeCols[i] == 0) {
                qC.offer(i);
            }
        }
        int colInd = 0;
        while(!qC.isEmpty() && colInd < k) {
            int current = qC.poll();
            colIndex[current] = colInd;
            for(int node : colGraph.get(current)) {
                inDegreeCols[node]--;
                if(inDegreeCols[node] == 0) qC.offer(node);
            }
            colInd++;
        }
        int[][] kMat = new int[k][k];
        for(int i = 1; i <= k; i++) {
            if(inDegreeCols[i] != 0) return new int[][]{};
        }
        for(int i = 1; i <= k; i++) kMat[rowIndex[i]][colIndex[i]] = i;
        return kMat;
    }
}