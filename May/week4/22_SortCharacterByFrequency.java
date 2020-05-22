/*
        Given a string, sort it in decreasing order based on the frequency of characters.

        Example 1:
        Input : "tree"
        Output: "eert"
        Explanation:
                'e' appears twice while 'r' and 't' both appear once.
                So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

        Example 2:
        Input : "cccaaa"
        Output: "cccaaa"
        Explanation:
                Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
                Note that "cacaca" is incorrect, as the same characters must be together.

        Example 3:
        Input :"Aabb"
        Output:"bbAa"
        Explanation:
                "bbaA" is also a valid answer, but "Aabb" is incorrect.
                Note that 'A' and 'a' are treated as two different characters.
*/
class Solution {
        public String frequencySort(String s) {
                Map<Character, Integer> count = new HashMap();
                for(char c : s.toCharArray()){
                        count.put(c, count.getOrDefault(c, 0) + 1);
                }
            
                PriorityQueue<Character> maxHeap = new PriorityQueue(new Comparator<Character>() {
                        public int compare(Character a, Character b){
                                return count.get(b) - count.get(a);
                        }
                });
            
                maxHeap.addAll(count.keySet());
                StringBuilder str = new StringBuilder();
                while(!maxHeap.isEmpty()){
                        Character c = maxHeap.poll();
                        int len     = count.get(c);
                        for(int i = 0 ; i < len; i++){
                                str.append(c);
                        }
                }
                return str.toString();
        }
}