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
        Map<Integer, Integer> inmap = new HashMap<>();
        for(int i=0;i<inorder.length;i++) {
            inmap.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1, inmap);
    }

    private TreeNode helper(int[] preOrder, int[] inOrder, int preStart, int preEnd, int inStart, int inEnd, Map<Integer, Integer> inmap) {
        if(preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preOrder[preStart]);
        int inRoot = inmap.get(preOrder[preStart]);
        int numsLeft = inRoot - inStart;
        
        root.left = helper(preOrder, inOrder, preStart+1, preStart+numsLeft, inStart, inRoot-1, inmap);
        root.right = helper(preOrder, inOrder, preStart + numsLeft + 1, preEnd, inRoot+1, inEnd, inmap);
        return root;
    }

}
