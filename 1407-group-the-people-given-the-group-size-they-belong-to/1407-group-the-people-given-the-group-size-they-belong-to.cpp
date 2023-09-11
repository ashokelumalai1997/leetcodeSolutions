class Solution {
public:
    vector<vector<int>> groupThePeople(vector<int>& groupSizes) {
        map<int,vector<vector<int>>> countToGroups;
        for(int i=0;i<groupSizes.size();i++)
        {
            if(countToGroups.find(groupSizes[i])==countToGroups.end())
            {
                vector<int> temp = {i};
                countToGroups[groupSizes[i]].push_back(temp);
            } else {
                if((countToGroups[groupSizes[i]].end()-1)->size()<groupSizes[i]) {
                    (countToGroups[groupSizes[i]].end()-1)->push_back(i);
                }
                else {
                    vector<int> temp = {i};
                    countToGroups[groupSizes[i]].push_back(temp);
                }
            }
        }
        vector<vector<int>> result;
        for(auto c:countToGroups){
            for(auto ca:c.second)
                result.push_back(ca);
        }
        return result;
    }
};