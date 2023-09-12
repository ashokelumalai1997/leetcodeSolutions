class Solution {
public:
    int minDeletions(string s) {
        unordered_map<char,int> charToFreqMap;
        unordered_map<int,char> freqToCharMap;
        for(auto c:s)
        {
            if(charToFreqMap.find(c)==charToFreqMap.end()) charToFreqMap[c]=1;
            else charToFreqMap[c]++;
        }
        int res=0;
        for(auto kv:charToFreqMap) {
            if(freqToCharMap.find(kv.second)==freqToCharMap.end())
            {
                freqToCharMap[kv.second]=kv.first;
                continue;
            }  {
                cout<<"else";
                int temp=kv.second;
                while(temp>=0)
                {
                    if(freqToCharMap.find(temp)==freqToCharMap.end()) {
                        if(temp) freqToCharMap[temp]=kv.first;
                        res+=(kv.second-temp);
                        cout<<res;
                        break;
                    }
                    temp--;
                }

            }
        }
        return res;
    }
};