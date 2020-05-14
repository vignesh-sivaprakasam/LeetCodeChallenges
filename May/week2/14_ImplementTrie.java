/*
        Implement a trie with insert, search, and startsWith methods.

        Example:

        Trie trie = new Trie();

        trie.insert("apple");
        trie.search("apple");   // returns true
        trie.search("app");     // returns false
        trie.startsWith("app"); // returns true
        trie.insert("app");   
        trie.search("app");     // returns true
        Note:

        - You may assume that all inputs are consist of lowercase letters a-z.
        - All inputs are guaranteed to be non-empty strings.
*/

class Trie {

        private Node root;
        
        /** Initialize your data structure here. */
        public Trie() {
            root = new Node();
        }
        
        /** Inserts a word into the trie. */
        public void insert(String word) {
            Node temp = root;
            for(char ch : word.toCharArray()){
                if(!temp.containsKey(ch)){
                    temp.put(ch, new Node());
                }
                temp = temp.get(ch);
            }
            temp.setEnd(true);
        }
        
        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Node temp = root;
            for(char ch : word.toCharArray()){
                if(!temp.containsKey(ch)){
                    return false;
                }
                temp = temp.get(ch);
            }
            return temp.isEnd();
        }
        
        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Node temp = root;
            for(char ch : prefix.toCharArray()){
                if(!temp.containsKey(ch)){
                    return false;
                }
                temp = temp.get(ch);
            }
            return true;
        }
    }
    
    class Node {
        private Node[] nodes;
        private final int TOTAL_NODES = 26;
        
        private boolean isEnd = false;
        
        public Node(){
            nodes = new Node[TOTAL_NODES];
        }
        
        public boolean containsKey(char ch){
            return nodes[ch - 'a'] != null;
        }
        
        public Node get(char ch){
            return nodes[ch - 'a'];
        }
        public void put(char ch, Node node){
            nodes[ch - 'a'] = node;
        }
        
        public void setEnd(boolean isEnd){
            this.isEnd = isEnd;
        }
        
        public boolean isEnd(){
            return isEnd;
        }
        
    }
    
    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */