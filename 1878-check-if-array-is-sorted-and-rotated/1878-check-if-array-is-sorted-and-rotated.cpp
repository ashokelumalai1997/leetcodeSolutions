class Solution {
public:
    bool check(vector<int>& nums) {
        int stepDownCount = 0;
        int n =nums.size();
        for(int i=1;i<nums.size();i++)
        {
            if(nums[i]<nums[i-1])
            {
                stepDownCount+=1;
            }
        }
        if(stepDownCount==0)
        {
            return true;
        }
        else if(stepDownCount==1)
        {
            return nums[0]>=nums[n-1];
        }
        return false;
    }
};