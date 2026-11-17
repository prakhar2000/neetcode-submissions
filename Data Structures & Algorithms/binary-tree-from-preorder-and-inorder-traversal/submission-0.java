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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, inorder.length - 1);
        
    }
    private int preorderIndex = 0;
    public TreeNode build(int[] preorder, int[] inorder, int l, int r){
        if(l>r)return null;

        int rootVal= preorder[preorderIndex++];
        TreeNode root= new TreeNode(rootVal);
        int mid= l;
        while(inorder[mid]!=rootVal){
            mid++;
        }

        root.left= build(preorder, inorder, l, mid-1);
        root.right= build(preorder, inorder, mid+1, r);

        return root;

    }
}
