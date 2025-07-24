class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        if(tasks.size()==0)
        {
            return 0;
        }
        if(n==0)
        {
            return tasks.size();
        }
        int maxCount=0;
        map<char,int> countMap;
        for(auto ch:tasks)
        {
            countMap[ch]++;
            if(maxCount<countMap[ch])
            {
                maxCount=countMap[ch];
            }
        }
        int numOfMax=0;
        for(auto i:countMap)
        {
            if(i.second==maxCount)
            {
                numOfMax++;
            }
        }
        return tasks.size()>((maxCount-1)*(n+1)+numOfMax)?tasks.size():((maxCount-1)*(n+1)+numOfMax);
    }
};