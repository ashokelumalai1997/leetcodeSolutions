class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int startPos=-1;
        int endPos=-1;
        for(int i=0;i<nums.size();i++)
        {
            if(nums[i]==target)
            {
                if(startPos<0)
                {
                    startPos=i;
                }
                if(endPos<i)
                {
                    endPos=i;
                }
            }
        }
        vector<int>res;
        res.push_back(startPos);
        res.push_back(endPos);
        return res;
    }
};