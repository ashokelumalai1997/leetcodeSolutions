class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        /*
        have a count var
        have a track var
        while in track
        iterate over every dist, update dist with recent dist if it is not -1
            set track var to true if any element is updated
        track min dist pos
        if new dist < 0, return count
        set min dist pos to -1
        update count
        if came out of track, return count


        dist = [1,3,4], speed = [1,1,1]

        */
        
        int[] timeArr = new int[dist.length];
        int minPos=-1;
        int minTime=Integer.MAX_VALUE;
        for(int i=0;i<dist.length;i++){
            timeArr[i]=dist[i]/speed[i];
            if(dist[i]%speed[i]!=0) timeArr[i]++;
            if(timeArr[i]<minTime){
                minTime=timeArr[i];
                minPos=i;
            }
        }
        timeArr[minPos]=Integer.MIN_VALUE;
        Arrays.sort(timeArr);
        int count = 1;
        for(int i=1;i<timeArr.length;i++){
            if(timeArr[i]<=count)
                break;
            count++;
        }
        return count;
    }
}