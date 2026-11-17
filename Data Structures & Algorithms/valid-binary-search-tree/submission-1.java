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

class Solution {
    public boolean isValidBST(TreeNode root) {
        // this apporach will not work , since it only check the local left and right
        //  boolean valcheck=false;

        // if (root==null || (root.left==null && root.right ==null)) return true;
        // if(root.left.val<root.val && root.right.val>root.val){
        //   valcheck=true;
        // }

        // boolean l= isValidBST(root.left);
        // boolean r= isValidBST(root.right);

        // return valcheck && l && r;
        // right approach to check using helper function

        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean validate(TreeNode node, long min, long max) {
        if (node == null)
            return true;
        if (node.val <= min || node.val >= max) {
            return false;
        }

        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
}
