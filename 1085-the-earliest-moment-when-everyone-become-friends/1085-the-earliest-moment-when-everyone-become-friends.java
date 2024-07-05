class UnionFind {
    int[] parentInfo;
    public int groups;
    public UnionFind(int n) {
        parentInfo = new int[n];
        for(int i = 0; i < n; i ++) {
            parentInfo[i] = i;
        }
        this.groups = n;
    }

    public int find(int member){
        if(parentInfo[member] != member) return parentInfo[member] = find(parentInfo[member]);
        return member;
    }

    public boolean union(int memberA, int memberB){
        int parentA = find(memberA);
        int parentB = find(memberB);
        if(parentA == parentB) return false;
        parentInfo[parentA] = parentB;
        this.groups--;
        return true;
    }
}
class Solution {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        UnionFind uf = new UnionFind(n);
        int earliestTime = logs[0][0];
        for(int i = 0; i < logs.length; i++) {
            int member1 = logs[i][1];
            int member2 = logs[i][2];
            if(uf.union( member1 , member2 ) == true) {
                earliestTime = logs[i][0];
            }
        }
        if(uf.groups != 1) return -1;
        return earliestTime;
    }
}