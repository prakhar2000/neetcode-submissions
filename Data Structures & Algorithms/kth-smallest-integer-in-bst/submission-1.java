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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> sorted = new ArrayList<>();
        inorder(root, sorted, k);
        return sorted.get(k - 1);
        
    }
    private void inorder(TreeNode node, List<Integer> sorted, int k) {
        if (node == null) {
            return;
        }
        inorder(node.left, sorted, k);
        sorted.add(node.val);
        if(sorted.size()>k){
            return ;
        }
        inorder(node.right, sorted, k);
    }
}
