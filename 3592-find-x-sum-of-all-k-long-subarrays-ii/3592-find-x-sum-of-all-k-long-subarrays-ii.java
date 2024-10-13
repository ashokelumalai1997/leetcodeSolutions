import java.util.*;

class Entry implements Comparable<Entry> {
    int num;
    int freq;

    public Entry(int num, int freq) {
        this.num = num;
        this.freq = freq;
    }

    @Override
    public int compareTo(Entry a) {
        if (this.freq == a.freq) return a.num - this.num;
        return a.freq - this.freq;
    }

    public boolean isBetterThan(Entry a) {
        return this.compareTo(a) < 0;
    }
}

class FindXSum {
    private TreeSet<Entry> topX;
    private TreeSet<Entry> otherThanX;
    private Map<Integer, Entry> entryMap;
    private int x;
    private int k;
    private int[] nums;
    private long sum;

    public FindXSum(int[] nums, int x, int k) {
        this.nums = nums;
        this.k = k;
        this.x = x;
        this.sum = 0;
        topX = new TreeSet<>();
        otherThanX = new TreeSet<>();
        entryMap = new HashMap<>();
    }

    private void addRight(int pos) {
        int num = nums[pos];
        Entry e = entryMap.computeIfAbsent(num, key -> new Entry(key, 0));
        removeFromSets(e);
        e.freq++;
        addToSets(e);
    }

    private void removeLeft(int pos) {
        int num = nums[pos];
        Entry e = entryMap.get(num);
        removeFromSets(e);
        e.freq--;
        // if (e.freq > 0) {
        //     addToSets(e);
        // } else {
        //     entryMap.remove(num);
        // }
        addToSets(e);
        if(!otherThanX.isEmpty()) {
            Entry en = otherThanX.first();
            otherThanX.removeFirst();
            addToSets(en);
        }
    }

    private void removeFromSets(Entry e) {
        if (topX.remove(e)) {
            sum -= (long) e.freq * e.num;
        } else {
            otherThanX.remove(e);
        }
    }

    private void addToSets(Entry e) {
        if (topX.size() < x) {
            topX.add(e);
            sum += (long) e.freq * e.num;
        } else {
            Entry lastInTopX = topX.last();
            if (e.isBetterThan(lastInTopX)) {
                topX.remove(lastInTopX);
                sum -= (long) lastInTopX.freq * lastInTopX.num;
                topX.add(e);
                sum += (long) e.freq * e.num;
                otherThanX.add(lastInTopX);
            } else {
                otherThanX.add(e);
            }
        }
    }

    public long[] getXSumArr() {
        int n = nums.length;
        long[] res = new long[n - k + 1];
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            addRight(right);
            
            if (right >= k - 1) {
                res[left] = sum;
                removeLeft(left);
                left++;
            }
        }
        
        return res;
    }
}

class Solution {
    public long[] findXSum(int[] nums, int k, int x) {
        FindXSum findXSum = new FindXSum(nums, x, k);
        return findXSum.getXSumArr();
    }
}