/*
        Given a set of distinct integers, nums, return all possible subsets (the power set).

        Note: The solution set must not contain duplicate subsets.

        Example:

        Input: nums = [1,2,3]
        Output:
        [
                [3],
                [1],
                [2],
                [1,2,3],
                [1,3],
                [2,3],
                [1,2],
                []
        ]
*/
class Solution {
        public List<List<Integer>> subsets(int[] nums) {
                List<List<Integer>> list = new LinkedList<List<Integer>>();
                createPowerList(nums, 0, list, new LinkedList<Integer>());
                return list;
        }
        private void createPowerList(int[] nums, int index, List<List<Integer>> list, List<Integer> subList){
                list.add(new LinkedList<Integer>(subList));
                for(int i = index; i < nums.length; i++){
                        subList.add(nums[i]);
                        createPowerList(nums, i + 1, list, subList);
                        subList.remove(subList.size() - 1);
                }
        }
}