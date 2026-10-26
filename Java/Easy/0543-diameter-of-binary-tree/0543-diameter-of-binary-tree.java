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
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        f(root);

        return diameter;
    }

    int f(TreeNode root) {
         if (root == null)
            return 0;

        int lh = f(root.left);

        int rh = f(root.right);

        diameter = Math.max(diameter, lh + rh);

        return 1 + Math.max(lh, rh);

    }
}