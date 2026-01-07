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
    long totalSum = 0;
    long maxProduct = 0;
    final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        calculateTotalSum(root);
        calculateSubtreeSumsAndMaxProduct(root);
        return (int) (maxProduct % MOD);
    }

    private void calculateTotalSum(TreeNode node) {
        if (node == null) return;
        totalSum += node.val;
        calculateTotalSum(node.left);
        calculateTotalSum(node.right);
    }

    private long calculateSubtreeSumsAndMaxProduct(TreeNode node) {
        if (node == null) return 0;
        long subTreeSum = node.val + calculateSubtreeSumsAndMaxProduct(node.left) + calculateSubtreeSumsAndMaxProduct(node.right);
        long otherSubtreeSum = totalSum - subTreeSum;
        maxProduct = Math.max(maxProduct, subTreeSum * otherSubtreeSum);
        return subTreeSum;
    }
}
