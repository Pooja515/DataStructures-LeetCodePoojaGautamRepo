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

    int longestPath = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root);

        return longestPath;
    }

    private int dfs(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        if (root.left != null && root.left.val == root.val) {
            left++;
        } else {
            left = 0;
        }

        if (root.right != null && root.right.val == root.val) {
            right++;
        } else {
            right = 0;
        }

        longestPath = Math.max(longestPath,left + right);

        return Math.max(left, right);
    }
}
