/*
        Given a 2D board and a word, find if the word exists in the grid.

        The word can be constructed from letters of sequentially adjacent cell, 
        where "adjacent" cells are those horizontally or vertically neighboring. 
        The same letter cell may not be used more than once.

        Example:

        board =
        [
                ['A','B','C','E'],
                ['S','F','C','S'],
                ['A','D','E','E']
        ]

        Given word = "ABCCED", return true.
        Given word = "SEE", return true.
        Given word = "ABCB", return false.

        Constraints:

        board and word consists only of lowercase and uppercase English letters.
        1 <= board.length <= 200
        1 <= board[i].length <= 200
        1 <= word.length <= 10^3
*/
class Solution {
        public boolean exist(char[][] board, String word) {
                if(board.length == 0 || board[0].length == 0){
                        return false;
                }
                int m = board.length;
                int n = board[0].length;
                boolean[][] visited = new boolean[m][n];
                for(int i = 0; i < m; i++){
                        for(int j = 0; j < n; j++){
                                if(checkMatrix(board, visited, word, 0, i, j)){
                                        return true;
                                }
                        }
                }
                return false;
        }
        
        private boolean checkMatrix(char[][] board, boolean[][] visited, String word, int index, int i, int j){
                if(index == word.length()) return true;
                if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
                
                if(word.charAt(index) != board[i][j] || visited[i][j]) return false;
                
                visited[i][j]   = true;
                boolean isExist = checkMatrix(board, visited, word, index+1, i-1, j) || checkMatrix(board, visited, word, index+1,i, j-1) ||checkMatrix(board, visited, word, index+1, i+1, j) || checkMatrix(board, visited, word, index+1, i, j+1);
                visited[i][j]   = false;
                return isExist;
        }
}