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

class CameraResult {
    int coveredByChild;
    int coveredBySelf;
    int coveredByParent;

    public CameraResult(int a, int b, int c) {
        this.coveredByChild = a;
        this.coveredBySelf = b;
        this.coveredByParent = c;

    }
}

class Solution {

    private CameraResult getCamRes(TreeNode root) {
        if(root == null) {
            return new CameraResult(0, 1, 0);
        }

        if(root.right == null && root.left == null) {
            return new CameraResult(1, 1, 0);
        }
        CameraResult right = getCamRes(root.right);
        CameraResult left = getCamRes(root.left);

        int coveredBySelf = 1;
        int leftRes = Math.min(left.coveredBySelf, left.coveredByChild);
        leftRes = Math.min(leftRes, left.coveredByParent);
        coveredBySelf += leftRes;

        int rightRes = Math.min(right.coveredBySelf, right.coveredByChild);
        rightRes = Math.min(rightRes, right.coveredByParent);
        coveredBySelf += rightRes;

        leftRes = left.coveredBySelf;
        leftRes = Math.min(left.coveredByChild, leftRes);

        rightRes = right.coveredBySelf;
        rightRes = Math.min(right.coveredByChild, rightRes);

        int coveredByParent = 0;

        coveredByParent += rightRes;
        coveredByParent += leftRes;

        int coveredByChild = 0;

        leftRes = left.coveredBySelf;
        rightRes = Math.min(right.coveredBySelf, right.coveredByChild);

        int temp = leftRes + rightRes;

        rightRes = right.coveredBySelf;
        leftRes = Math.min(left.coveredBySelf, left.coveredByChild);

        coveredByChild = Math.min(temp, leftRes + rightRes);

        return new CameraResult(coveredByChild, coveredBySelf, coveredByParent);



    }
    public int minCameraCover(TreeNode root) {
        CameraResult c = getCamRes(root);

        return Math.min(c.coveredBySelf, c.coveredByChild);
    }
}