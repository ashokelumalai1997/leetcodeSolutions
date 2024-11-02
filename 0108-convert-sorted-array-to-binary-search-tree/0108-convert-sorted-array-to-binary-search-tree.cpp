/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    TreeNode* iotToTree(vector<int> &nums,  int startPos, int endPos)
    {
        if(startPos>endPos)
            return NULL;
        int midPos = (startPos+endPos)/2;
        TreeNode* root= new TreeNode(nums[midPos]);
        root->left = iotToTree(nums, startPos, midPos-1);
        root->right = iotToTree(nums, midPos+1,endPos);
        return root;
    }
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        TreeNode* root = NULL;
        root = iotToTree(nums,0,nums.size()-1);
        return root;
    }
};