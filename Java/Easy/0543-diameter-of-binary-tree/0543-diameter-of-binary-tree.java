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
    int diameter =0;
    public int diameterOfBinaryTree(TreeNode root) {
        
        if(root == null) return 0;
        depth(root);

        return diameter; 
    }
    int depth(TreeNode root){
        if(root == null) return 0;
        int l = depth(root.left);
        int r= depth(root.right);

        diameter = Math.max(diameter,l+r);

        return 1 + Math.max(l,r);
    }
}