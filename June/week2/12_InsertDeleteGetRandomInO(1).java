/*
        Design a data structure that supports all following operations in average O(1) time.

        1. insert(val): Inserts an item val to the set if not already present.
        2. remove(val): Removes an item val from the set if present.
        3. getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.

        Example:
        // Init an empty set.
        RandomizedSet randomSet = new RandomizedSet();

        // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        randomSet.insert(1);

        // Returns false as 2 does not exist in the set.
        randomSet.remove(2);

        // Inserts 2 to the set, returns true. Set now contains [1,2].
        randomSet.insert(2);

        // getRandom should return either 1 or 2 randomly.
        randomSet.getRandom();

        // Removes 1 from the set, returns true. Set now contains [2].
        randomSet.remove(1);

        // 2 was already in the set, so return false.
        randomSet.insert(2);

        // Since 2 is the only number in the set, getRandom always return 2.
        randomSet.getRandom();
*/

class RandomizedSet {

        /** Initialize your data structure here. */
        Map<Integer, Integer> map;
        List<Integer> list;
        Random rand;
        public RandomizedSet() {
                map     = new HashMap();
                list    = new ArrayList();
                rand    = new Random();
        }
        
        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
                if(map.containsKey(val)){
                        return false;
                }
                int size = list.size();
                list.add(val);
                
                map.put(val, size);
                return true;
        }
        
        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
                if(map.containsKey(val)){
                        int index   = map.get(val);        
                        if(index < list.size() - 1){
                                int lastVal = list.get(list.size()-1);
                                swap(list, index, list.size() - 1);
                                map.put(lastVal, index);    
                        }
                        
                        list.remove(list.size() - 1);
                        map.remove(val);
                        return true;
                }
                return false;
        }
        
        private void swap(List<Integer> list, int i, int j){
                int temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
        }
        
        /** Get a random element from the set. */
        public int getRandom() {
                int index = rand.nextInt(list.size());
                return list.get(index);
        }
}
    
    /**
     * Your RandomizedSet object will be instantiated and called as such:
     * RandomizedSet obj = new RandomizedSet();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */