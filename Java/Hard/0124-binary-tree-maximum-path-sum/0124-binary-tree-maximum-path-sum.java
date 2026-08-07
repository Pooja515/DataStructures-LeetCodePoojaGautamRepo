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
    int maxsum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        maxPath(root);

        return maxsum;
    }

    int  maxPath(TreeNode root){
        if(root == null) return 0;
        int l = maxPath(root.left);
        int r = maxPath(root.right);

        if(l<0) l=0;
        if(r<0) r=0;

        maxsum = Math.max(maxsum , root.val + l+ r);

        return root.val + Math.max(l,r);

    }
}