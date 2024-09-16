class Solution {
    class Time implements Comparable<Time>{
        int min;
        int hour;
        public Time(int h, int m) {
            this.hour = h;
            this.min = m;
        }

        public int compareTo(Time t) {
            if(this.hour == t.hour) return this.min - t.min;
            return this.hour - t.hour;
        }

    }
    public int findMinDifference(List<String> timePoints) {
        List<Time> tL = new ArrayList<>();
        for(String time : timePoints) {
            tL.add(new Time(Integer.valueOf(time.split(":")[0]), Integer.valueOf(time.split(":")[1])));
        }
        Collections.sort(tL);
        int minDiff = Integer.MAX_VALUE;
        int prevHour = tL.get(0).hour;
        int prevMin = tL.get(0).min;
        for(int i = 1; i < tL.size(); i++) {
            int currHour = tL.get(i).hour;
            int currMin = tL.get(i).min;
            int mins = (currHour - prevHour)*60 - prevMin + currMin;
            mins = Math.min(mins, 1440 - mins);
            prevHour = currHour;
            prevMin = currMin;
            minDiff = Math.min(minDiff, mins);
        }
        int mins = (-1*tL.get(0).hour + tL.get(tL.size()-1).hour)*60 - tL.get(0).min + tL.get(tL.size()-1).min;
        mins = Math.min(mins, 1440 - mins);
        minDiff = Math.min(minDiff, mins);
        return minDiff;
    }
}