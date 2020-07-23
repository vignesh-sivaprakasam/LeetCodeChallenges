/*
        Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

        For example:
        Given binary tree [3,9,20,null,null,15,7],
                3
               / \
              9  20
                /  \
               15   7
        return its zigzag level order traversal as:
        [
                [3],
                [20,9],
                [15,7]
        ]
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
                List<List<Integer>> list = new LinkedList();
                helper(root, 0, list);
                return list;
        }
        
        private void helper(TreeNode root, int level, List<List<Integer>> list){
                if(root == null){
                        return;
                }
                if(level == list.size()){
                        list.add(new LinkedList());
                }
                if(level % 2 == 0){
                        list.get(level).add(root.val);
                } else {
                        list.get(level).add(0, root.val);
                }
                
                helper(root.left, level+1, list);
                helper(root.right, level+1, list);
        }
}