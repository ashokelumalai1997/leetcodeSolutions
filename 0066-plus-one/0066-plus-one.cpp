class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int carry=1;
        for(int i=digits.size()-1;i>=0;i--)
        {
            if(!carry)
            {   
                break;
            }
            int temp=digits[i];
            digits[i]=(temp+carry)%10;
            carry=(temp+carry)/10;
        }
        if(carry)
            digits.insert(digits.begin(),carry);
        return digits;
    }
};