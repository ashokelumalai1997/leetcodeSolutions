class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] dist = new int[26][26];
        for(int i = 0; i < 26; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        int n = original.length;
        for(int i = 0; i < n; i++){
            int existing = dist[original[i] - 'a'][changed[i] - 'a'];
            dist[original[i] - 'a'][changed[i]-'a'] = Math.min(existing, cost[i]);
        }
        for(int i = 0; i < 26; i++) {
            dist[i][i] = 0;
        }
        for(int i = 0; i < 26; i++) {
            for(int j = 0; j < 26; j++) {
                for(int k = 0; k < 26; k++) {
                    if(dist[j][i] == Integer.MAX_VALUE || dist[i][k] == Integer.MAX_VALUE) continue;
                    dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
                }
            }
        }
        long result = 0;
        n = source.length();
        for(int i = 0; i < n; i++) {
            if(dist[source.charAt(i) - 'a'][target.charAt(i) - 'a'] == Integer.MAX_VALUE) return -1;
            result += dist[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
        }
        return result;
    }
}