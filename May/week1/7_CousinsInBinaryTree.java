/*
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

 

Example 1:
                1
        2               3
4

Input: root = [1,2,3,4], x = 4, y = 3
Output: false

Example 2:
                 1
            /        \
        2               3
          \               \
           4               5
        
Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true

Example 3:
                 1
             /      \
            2         3
             \ 
              4  

Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
 

Note:

The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100.
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
        private int xDepth = 0;
        private int yDepth = 0;
        
        private TreeNode xParent = null;
        private TreeNode yParent = null;
        
        public boolean isCousins(TreeNode root, int x, int y) {
            findDepths(root, null, x, y, 0);
            if((xDepth != yDepth) || (xParent == yParent)){
                return false;
            }
            return true;
        }
        
        private void findDepths(TreeNode root, TreeNode parent, int x, int y, int depth){
            if(root == null){
                return;
            }
            if(root.val == x){
                xDepth = depth;
                xParent = parent;
            }
            if(root.val == y){
                yDepth  = depth;
                yParent = parent;
            }
            if(xParent != null && yParent != null){
                return;
            }
            findDepths(root.left , root, x, y, depth + 1);
            findDepths(root.right, root, x, y, depth + 1);
        }
    }