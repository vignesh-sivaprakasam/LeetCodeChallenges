/* 
Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
*/
class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            int[] ransom = new int[26];
            for(char c : ransomNote.toCharArray()){
                ransom[c-'a'] += 1;
            }
            for(char c : magazine.toCharArray()){
                ransom[c - 'a'] -= 1;
            }
            for(int i = 0; i < 26; i++){
                if(ransom[i] > 0){
                    return false;
                }
            }
            return true;
        }
}