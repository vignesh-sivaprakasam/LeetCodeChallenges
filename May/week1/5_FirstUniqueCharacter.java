/*
        Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

        Examples:

        s = "leetcode"
        return 0.

        s = "loveleetcode",
        return 2.
        Note: You may assume the string contain only lowercase letters.

*/

class Solution {
        class Tuple {
            int index;
            int count;
            Tuple(int index){
                this.index = index;
                this.count = 1;
            }
            
            public int getIndex(){
                return this.index;
            }
            
            public int getCount(){
                return this.count;
            }
            public void incrementCount(){
                this.count += 1;
            }
        }
        public int firstUniqChar(String s) {
            Map<Character, Tuple> map = new HashMap();
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(map.containsKey(c)){
                    map.get(c).incrementCount();
                } else {
                    map.put(c, new Tuple(i));
                }
            }
            int minIndex = Integer.MAX_VALUE;
            for(Map.Entry<Character,Tuple> entry: map.entrySet()){
                Tuple tuple = entry.getValue();
                if(tuple.getCount() == 1){
                    minIndex = Math.min(minIndex, tuple.getIndex());
                }
            }
            return minIndex == Integer.MAX_VALUE ? -1 : minIndex;
        }
}