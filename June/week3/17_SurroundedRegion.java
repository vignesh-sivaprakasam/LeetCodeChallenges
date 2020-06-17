/*
        Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

        A region is captured by flipping all 'O's into 'X's in that surrounded region.

        Example:

        X X X X
        X O O X
        X X O X
        X O X X
        After running your function, the board should be:

        X X X X
        X X X X
        X X X X
        X O X X

        Explanation:
        Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
*/
class Solution {
        public void solve(char[][] board) {
                int rowLen = board.length;
                if(rowLen <= 2){
                        return;
                }
                int colLen = board[0].length;
                if(colLen <= 2){
                        return;
                }
                for(int row = 0; row < rowLen; row++){
                        if(board[row][0] == 'O')
                                changeBoard(board, row, 0, rowLen, colLen);
                        if(board[row][colLen - 1] == 'O')
                                changeBoard(board, row, colLen - 1, rowLen, colLen);
                }
                
                for(int col = 0 ; col < colLen; col++){
                        if(board[0][col] == 'O')
                                changeBoard(board, 0, col, rowLen, colLen);
                        if(board[rowLen - 1][col] == 'O')
                                changeBoard(board, rowLen - 1, col, rowLen, colLen);
                }
                
                for(int i = 0 ; i < rowLen; i++){
                        for(int j = 0 ; j < colLen; j++){
                                if(board[i][j] == 'O'){
                                        board[i][j] = 'X';
                                } else if(board[i][j] == '1'){
                                        board[i][j] = 'O';
                                }
                        }
                }
        }
        
        private void changeBoard(char[][] board, int i, int j, int rowLen, int colLen){
                if(board[i][j] == 'O'){
                        board[i][j] = '1';
                        if(i > 0)
                                changeBoard(board, i - 1, j, rowLen, colLen);
                        if(j > 0)
                                changeBoard(board, i, j - 1, rowLen, colLen);
                        if(i + 1 < rowLen)
                                changeBoard(board, i + 1, j, rowLen, colLen);
                        if(j + 1 < colLen)
                                changeBoard(board, i, j + 1, rowLen, colLen);
                }
        }
}