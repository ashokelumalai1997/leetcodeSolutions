class Solution {
public:
    int candy(vector<int>& ratings) {
        vector<int> result(ratings.size(),1);
        for(int i=0;i<ratings.size();i++){
          if(i-1>=0&&ratings[i]>ratings[i-1]) result[i]=result[i-1]+1;
          
        }
        for(int i=ratings.size()-1;i>=0;i--){
          if(i+1<result.size()&&ratings[i+1]<ratings[i]) result[i]=max(result[i],result[i+1]+1);
        }
        int res = accumulate(result.begin(),result.end(),0);
        return res;
    }
};