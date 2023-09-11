class Solution {
public:
    vector<vector<int>> groupThePeople(vector<int>& groupSizes) {
        map<int,vector<int>> countToGroups;
        vector<vector<int>> result;
        for(int i=0;i<groupSizes.size();i++)
        {
            if(countToGroups.find(groupSizes[i])==countToGroups.end())
            {
                vector<int> temp = {i};
                countToGroups[groupSizes[i]]=temp;
            } else {
                if(countToGroups[groupSizes[i]].size()<groupSizes[i]) {
                    countToGroups[groupSizes[i]].push_back(i);
                }
                else {
                    result.push_back(countToGroups[groupSizes[i]]);
                    countToGroups.erase(groupSizes[i]);
                    vector<int> temp = {i};
                    countToGroups[groupSizes[i]]=(temp);
                }
            }
        }
        
        for(auto c:countToGroups){
            
                result.push_back(c.second);
        }
        return result;
    }
};