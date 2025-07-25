class Solution {
    
    private boolean overlap(int[] a, int[] b) {
        int l1 = a.length;
        
        int l2 = b.length;
        
        int i = 0;
        int j = 0;
        
        
        while(i < l1 && j < l2) {
            if(a[i] == b[j]) {
                return true;
            } else if(a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }
        return false;
    }
    
    public int numBusesToDestination(int[][] routes, int source, int target) {
        int r = routes.length;
        
        if(source == target) return 0;
        
        Queue<Integer> routeQueue = new LinkedList<>();
        
        boolean[] vis = new boolean[r];
        
        
        boolean sourceFound = false;
        boolean targetFound = false; 
        
        
        Map<Integer,List<Integer>> routeMap = new HashMap<>();
        
        for(int[] route : routes) {
            Arrays.sort(route);
        }
        
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < r; j++) {
                if(i == j)  continue;
                routeMap.putIfAbsent(i, new ArrayList<>());
                    routeMap.putIfAbsent(j, new ArrayList<>());
                if(overlap(routes[i], routes[j])) {
                    
                    routeMap.get(i).add(j);
                    routeMap.get(j).add(i);
                }
            }
        }
        
        
        for(int i = 0; i < r; i++) {
            for(int stop : routes[i]) {
                if(stop == source) {
                    routeQueue.add(i);
                    sourceFound = true;
                    // vis[i] = true;
                }
                if(stop == target) {
                    targetFound = true;
                }
            }
        }
        
        if(!sourceFound || !targetFound) return -1;
        
        
        int dist = 1;
        
        
        
        
        
        
        
        while(!routeQueue.isEmpty()) {
            
            int currentSize = routeQueue.size();
            
            
            for(int i = 0; i < currentSize; i++) {
                int routeId = routeQueue.poll();
                vis[routeId] = true;
                
                for(int stop : routes[routeId]) {
                    if(stop == target) return dist;
                    
                }
                
                for(int nextRoute : routeMap.get(routeId)) {
                    if(!vis[nextRoute]) {
                        vis[nextRoute] = true;
                        routeQueue.add(nextRoute);
                    }
                }
            }
            dist++;
            
        }
        
        return -1;
    }
}