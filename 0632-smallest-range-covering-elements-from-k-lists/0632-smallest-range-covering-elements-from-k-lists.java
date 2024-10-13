class Entry implements Comparable<Entry> {

    int num;
    int listNo;
    public Entry(int num, int listNo) {
        this.num = num;
        this.listNo = listNo;
    }

    public int compareTo(Entry e) {
        return this.num - e.num;
    }
}

class RangeFinder{
    List<List<Integer>> unMergedList;
    List<Entry> list;
    public RangeFinder(List<List<Integer>> nums){
        this.unMergedList = nums;
        list = new ArrayList<>();
    }

    private void mergeLists() {
        PriorityQueue<Entry> pq = new PriorityQueue<>();
        int n = unMergedList.size();
        int[] indexTracker = new int[n];
        for(int i = 0; i < n; i++) {
            if(indexTracker[i] >= unMergedList.get(i).size()) continue;
            int currentNo = unMergedList.get(i).get(indexTracker[i]);
            pq.offer(new Entry(currentNo, i));
            indexTracker[i]++;
        }
        while(!pq.isEmpty()) {
            Entry currentEntry = pq.poll();
            list.add(currentEntry);
            if(indexTracker[currentEntry.listNo] < unMergedList.get(currentEntry.listNo).size()) {
                pq.offer(new Entry(unMergedList.get(currentEntry.listNo).get(indexTracker[currentEntry.listNo]), currentEntry.listNo));
                indexTracker[currentEntry.listNo]++;
            }
        }
    }

    public int[] getRange(){
        this.mergeLists();
        int left = 0;
        int right = 0;
        int n = list.size();
        Map<Integer, Integer> listNoToFreq = new HashMap<>();
        int rangeLen = Integer.MAX_VALUE;
        int rangeStart = 0;
        int rangeEnd = Integer.MAX_VALUE;
        while(right < n) {
            int currentFreq = listNoToFreq.getOrDefault(list.get(right).listNo, 0);
            listNoToFreq.put(list.get(right).listNo, currentFreq+1);
            while(listNoToFreq.size() == unMergedList.size()) {
                int rightNo = list.get(right).num;
                int leftNo = list.get(left).num;
                int currentRange = (rightNo - leftNo + 1);
                if(currentRange < rangeLen) {
                    rangeLen = currentRange;
                    rangeStart = leftNo;
                    rangeEnd = rightNo;
                }
                int currentLeftFreq = listNoToFreq.get(list.get(left).listNo);
                if(currentLeftFreq == 1) listNoToFreq.remove(list.get(left).listNo);
                else listNoToFreq.put(list.get(left).listNo, currentLeftFreq-1);
                left++;
            }
            right++;
        }
        return new int[]{rangeStart, rangeEnd};
    }

    


}
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        RangeFinder rf = new RangeFinder(nums);
        return rf.getRange();
    }
}