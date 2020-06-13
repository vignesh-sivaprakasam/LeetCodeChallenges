/*
        Given a set of distinct positive integers, 
        find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:
        Si % Sj = 0 or Sj % Si = 0.

        If there are multiple solutions, return any subset is fine.

        Example 1:
        Input: [1,2,3]
        Output: [1,2] (of course, [1,3] will also be ok)

        Example 2:
        Input: [1,2,4,8]
        Output: [1,2,4,8]
*/
class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
                List<Integer> result = new LinkedList();
                List<Integer> curSubset = new LinkedList();
                Arrays.sort(nums);
                // helper(nums, 0, curSubset, result);
                result = lisDp(nums);
                return result;
        }
        
        private List<Integer> lisDp(int[] nums){
                int[] dp        = new int[nums.length];
                int[] preIndex  = new int[nums.length];
                
                Arrays.fill(dp, 1);
                Arrays.fill(preIndex, -1);
                
                int max = 0, index = -1;
                for(int i = 0; i < nums.length; i++){
                        for(int j = 0; j < i ; j++){
                                if(nums[i] % nums[j] == 0){
                                        if(dp[i] < 1 + dp[j]){
                                                dp[i] = 1+dp[j];
                                                preIndex[i] = j;
                                        }
                                }
                        }
                        if(max < dp[i]){
                                max = dp[i];
                                index = i;
                        }
                }
                
                List<Integer> list = new LinkedList();
                while(index != -1){
                        list.add(nums[index]);
                        index = preIndex[index];
                }
                
                return list;
        }
                
        private void helper(int[] nums, int index, List<Integer> curSubset, List<Integer> result){
                if(index == nums.length){
                        if(curSubset.size() > result.size()){
                                result.clear();
                                result.addAll(curSubset);
                        }
                        return;
                }
                for(int i = index; i < nums.length; i++){
                        if(isDivisble(curSubset, nums[i])){
                                curSubset.add(nums[i]);
                                helper(nums , i+1, curSubset, result);
                                curSubset.remove(curSubset.size()-1);    
                        } else {
                                helper(nums, i+1, curSubset, result);
                        }
                }
        }
                
        private boolean isDivisble(List<Integer> curSubset, int num){
                for(Integer val : curSubset){
                        if(num % val != 0){
                                return false;
                        }
                }
                return true;
        }
}