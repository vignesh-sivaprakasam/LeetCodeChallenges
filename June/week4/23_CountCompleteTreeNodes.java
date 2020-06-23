/*
        Given a complete binary tree, count the number of nodes.

        Note:

        Definition of a complete binary tree from Wikipedia:
        In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

        Example:

        Input: 
                  1
                /   \
               2     3
              / \   /
             4  5  6

        Output: 6
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
        public int countNodes(TreeNode root) {
                return count(root);
        }
        
        private int count(TreeNode root){
                if(root == null){
                        return 0;
                }
                int nodeCount = 0;
                int h   = height(root);
                int rh  = height(root.right);
                if(rh == h-1){
                        return nodesInPerfectTree(rh) + 1 + count(root.right); // becoz left subtree is a perfect tree and +1 is for root; we can use h-1 or rh anything is fine
                }
                return nodesInPerfectTree(rh) + 1 + count(root.left);
        }
        
        private int nodesInPerfectTree(int height){
                return (int)Math.pow(2, height) - 1;
        }
        
        private int height(TreeNode root){
                if(root == null){
                        return 0;
                }
                return 1 + height(root.left);
        }
}