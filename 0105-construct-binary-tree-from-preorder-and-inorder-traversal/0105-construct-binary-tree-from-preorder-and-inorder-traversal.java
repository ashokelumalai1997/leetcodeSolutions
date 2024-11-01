/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


// f(pStart, pEnd, iStart, iEnd)
//     find pStart value in iot - pos
//         pStartL = pStart+1
//         pEndL = (pStart + pStart+pos-1)
//         right = f(pStartL, pEndL, iStart, pos-1)
//         left = f(pEndL+1, pEnd, pos+1, iEnd)
//     node.val = pos.val
//     node.right = right
//     node.left = left
//     return node


class Solution {

    private TreeNode build(int[] preorder, int[] inorder, 
                                int pStart, int pEnd, 
                                int iStart, int iEnd) {
        
        if(pStart > pEnd || iStart > iEnd) return null;
        TreeNode node = new TreeNode(preorder[pStart]);
        if(pStart == pEnd) {
            return node;
        }

        int pos = 0;
        for(int i = iStart; i <= iEnd; i++) {
            if(inorder[i] == preorder[pStart]) {
                pos = i;
                break;
            }
        }
//         pStartL = pStart+1
//         pEndL = (pStart + pStart+pos-1)
//         left = f(pStartL, pEndL, iStart, pos-1)
//         right = f(pEndL+1, pEnd, pos+1, iEnd)
        int pStartL = pStart+1;
        int pEndL = (pStart + (pos-iStart));
        // if(pos-1 >= 0)
            node.left = build(preorder, inorder, pStartL, pEndL, iStart, pos-1);
        // if(pEndL+1 <= pEnd && pos+1 <= iEnd)
        node.right = build(preorder, inorder, pEndL+1, pEnd, pos+1, iEnd);

        return node;


    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
             int n =preorder.length;
             return build(preorder, inorder, 0,n-1, 0, n-1);
    }
}


// preOrder - root, left, right

// inorder - left, root, right

// f(pStart, pEnd, iStart, iEnd)
//     find pStart value in iot - pos
//         pStartL = pStart+1
//         pEndL = (pStart + pStart+pos-1)
//         right = f(pStartL, pEndL, iStart, pos-1)
//         left = f(pEndL+1, pEnd, pos+1, iEnd)
//     node.val = pos.val
//     node.right = right
//     node.left = left
//     return node