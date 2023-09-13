class KthLargest {
public:
    int k;
    priority_queue<int, vector<int>,greater<int>> store;
    KthLargest(int k, vector<int>& nums) {
        this->k=k;
        for(auto a:nums)
        {
            store.push(a);
        }
        while(store.size()>k) store.pop();
    }
    
    int add(int val) {
        store.push(val);
        if(store.size()>k)
        {
            store.pop();
        }
        return store.top();
    }
};

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest* obj = new KthLargest(k, nums);
 * int param_1 = obj->add(val);
 */