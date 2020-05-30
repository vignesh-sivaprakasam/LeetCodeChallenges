/*
        We write the integers of A and B (in the order they are given) on two separate horizontal lines.
        Now, we may draw connecting lines: a straight line connecting two numbers A[i] and B[j] such that:
        A[i] == B[j];
        The line we draw does not intersect any other connecting (non-horizontal) line.
        Note that a connecting lines cannot intersect even at the endpoints: each number can only belong to one connecting line.

        Return the maximum number of connecting lines we can draw in this way.

        Example 1:
        Input: A = [1,4,2], B = [1,2,4]
        Output: 2
        Explanation: We can draw 2 uncrossed lines as in the diagram.
        We cannot draw 3 uncrossed lines, because the line from A[1]=4 to B[2]=4 will intersect the line from A[2]=2 to B[1]=2.

        Example 2:
        Input: A = [2,5,1,2,5], B = [10,5,2,1,5,2]
        Output: 3

        Example 3:
        Input: A = [1,3,7,1,7,5], B = [1,9,2,5,1]
        Output: 2
        
        Note:
        -  1 <= A.length <= 500
        -  1 <= B.length <= 500
        -  1 <= A[i], B[i] <= 2000
*/
class Solution {
        public int maxUncrossedLines(int[] A, int[] B) {
                int [][] dp = new int[A.length][B.length];
                for(int i = 0 ; i < A.length; i++){
                        Arrays.fill(dp[i], -1);
                }
                return maxUncrossed(A, B, A.length - 1, B.length - 1, dp);
        }
        
        private int maxUncrossed(int[] A, int[] B, int i, int j, int[][] dp){
                if(i < 0 || j < 0){
                        return 0;
                }
                if(dp[i][j] != -1){
                        return dp[i][j];
                }
                if(A[i] == B[j]){
                        return 1 + maxUncrossed(A, B, i-1, j-1, dp);
                }
                int one     = maxUncrossed(A, B, i-1, j, dp);
                int two     = maxUncrossed(A, B, i, j-1, dp);
                dp[i][j]    = Math.max(one, two);
                return dp[i][j];
        }
}