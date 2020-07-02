/*
        Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

        For example:
        Given binary tree [3,9,20,null,null,15,7],
                 3
                / \
               9  20
             /  \
            15   7
        return its bottom-up level order traversal as:
        [
                [15,7],
                [9,20],
                [3]
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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
                List list = new LinkedList();
                Queue<TreeNode> q = new LinkedList<TreeNode>();
                if(root == null){
                        return list;
                }
                q.offer(root);
                q.offer(null);
                List<Integer> subList = new LinkedList<Integer>();
                subList.add(root.val);
                list.add(subList);
                subList = new LinkedList<Integer>();
                while(q.size() > 1){
                        TreeNode curr = q.poll();
                        if(curr == null){
                                list.add(0,subList);
                                subList = new LinkedList<Integer>();
                                System.out.println(" q.size() :"+q.size());
                                if(q.size() >= 1){
                                        q.add(null);
                                }
                        } else {
                                if(curr.left != null){
                                        q.add(curr.left);
                                        subList.add(curr.left.val);
                                }
                                if(curr.right != null){
                                        q.add(curr.right);
                                        subList.add(curr.right.val);
                                }
                        }
                }
                return list;
        } 
}