class Solution {
    public int minAreaRect(int[][] points) {
        int result = Integer.MAX_VALUE;
        Map<Integer, HashSet<Integer>> xToYSet = new HashMap<>();
        for(int[] point : points) {
            if(!xToYSet.containsKey(point[0])) xToYSet.put(point[0], new HashSet<>());
            xToYSet.get(point[0]).add(point[1]);
        }

        for(int[] point : points) {
            for(int[] point1 : points) {
                if(point[0] == point1[0] || point[1] == point1[1]) continue;
                if(xToYSet.get(point[0]).contains(point1[1]) 
                    && xToYSet.get(point1[0]).contains(point[1])) {
                    result = Math.min(result, Math.abs(point[0] - point1[0])*Math.abs(point[1] - point1[1]));
                }
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;

    }
}