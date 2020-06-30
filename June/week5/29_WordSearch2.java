/*
        Given a 2D board and a list of words from the dictionary, 
        find all words in the board.
        Each word must be constructed from letters of sequentially adjacent cell, 
        where "adjacent" cells are those horizontally or vertically neighboring. 
        The same letter cell may not be used more than once in a word.

        Example:
        Input: 
        board = [
                ['o','a','a','n'],
                ['e','t','a','e'],
                ['i','h','k','r'],
                ['i','f','l','v']
        ]
        words = ["oath","pea","eat","rain"]
        Output: ["eat","oath"]
        
        Note:
        1. All inputs are consist of lowercase letters a-z.
        2. The values of words are distinct.
*/
class Solution {
        public List<String> findWords(char[][] board, String[] words) {
                List<String> result = new LinkedList();
                
                TrieNode root = buildTrie(words);
                for(int i = 0; i < board.length; i++){
                        for(int j = 0 ; j < board[0].length; j++){
                                dfs(board, i, j, root, result);
                        }
                }
                return result;
        }
        
        private void dfs(char[][] board, int row, int col, TrieNode trie, List<String> result){
                char c = board[row][col];
                if(c == '#' || trie.next[c-'a'] == null){
                        return;
                }
                trie = trie.next[c-'a'];
                if(trie.word != null){
                        result.add(trie.word);
                        trie.word = null;
                }
                
                board[row][col] = '#';
                if(row > 0)
                        dfs(board, row - 1, col, trie, result);
                
                if(row < board.length - 1)
                        dfs(board, row + 1, col, trie, result);
                
                if(col > 0)
                        dfs(board, row, col - 1, trie, result);
                
                if(col < board[0].length - 1)
                        dfs(board, row, col + 1, trie, result);
                
                board[row][col] = c;
        }
        
        private TrieNode buildTrie(String[] words){
                TrieNode root = new TrieNode();
                for(String word : words){
                        TrieNode node  = root;
                        for(char ch : word.toCharArray()){
                                if(node.next[ch - 'a'] == null){
                                        node.next[ch - 'a'] = new TrieNode();
                                }
                                node = node.next[ch - 'a'];
                        }
                        node.word = word;
                }
                
                return root;
        }
        
        class TrieNode {
                TrieNode[] next = new TrieNode[26];
                String word;
        }
}