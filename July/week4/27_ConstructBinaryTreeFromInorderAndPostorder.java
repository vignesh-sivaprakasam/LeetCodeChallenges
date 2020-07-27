/*
        Given inorder and postorder traversal of a tree, construct the binary tree.

        Note:
        You may assume that duplicates do not exist in the tree.

        For example, given

        inorder = [9,3,15,20,7]
        postorder = [9,15,7,20,3]
        Return the following binary tree:

                  3
                 / \
                9  20
                  /  \
                 15   7
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
        int postIndex;
        public TreeNode buildTree(int[] inorder, int[] postorder) {
                Map<Integer, Integer> map = new HashMap<Integer, Integer>();
                for(int i = 0 ; i < inorder.length; i++) {
                        map.put(inorder[i], i);
                }
                postIndex = postorder.length - 1;
                return construct(inorder, postorder, 0, postIndex, map);
        }
        
        private TreeNode construct(int[] inorder, int[] postorder, int start, int end, Map<Integer, Integer> map){
                if(start > end){
                        return null;
                }
                TreeNode root   = new TreeNode(postorder[postIndex]);
                int index       = map.get(postorder[postIndex--]);
                root.right      = construct(inorder, postorder, index + 1,  end , map);
                root.left       = construct(inorder, postorder, start, index - 1, map);
                
                return root;
        }
}