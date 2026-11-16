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
    public boolean isBalanced(TreeNode root) {

        if(root==null) return true;

        boolean leftT=isBalanced(root.left);
        boolean rightT= isBalanced(root.right);

        int lh= height(root.left);
        int rh= height(root.right);

        int diff= Math.abs(lh-rh);

        return (diff<=1) && leftT && rightT ;
        


    }

    public int height(TreeNode node){
        if(node==null) return 0;

        int l = height(node.left);
        int r = height(node.right);

        return Math.max(l,r)+1;
    }
}
