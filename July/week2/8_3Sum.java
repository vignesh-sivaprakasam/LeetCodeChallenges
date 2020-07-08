/*
        Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
        Find all unique triplets in the array which gives the sum of zero.

        Note:
        The solution set must not contain duplicate triplets.

        Example:
        Given array nums = [-1, 0, 1, 2, -1, -4],

        A solution set is:
        [
                [-1, 0, 1],
                [-1, -1, 2]
        ]
*/
class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
                List list = new LinkedList();
                if(nums.length < 3){
                        return list;
                }
                Arrays.sort(nums);
                int i,j;
                List<Integer> subList;
                for(int k = 0 ; k < nums.length - 2; k++){
                        
                        if(nums[k] > 0){
                                break;
                        }
                        if(k == 0 || nums[k] != nums[k-1]){
                                i = k + 1; 
                                j = nums.length - 1;
                                while(i < j){
                                        if(nums[i] + nums[j] + nums[k] == 0){
                                                list.add(Arrays.asList(nums[k], nums[i], nums[j]));
                                                i++; j--;
                                                while(i < j && nums[i] == nums[i-1]){
                                                        i++;
                                                }
                                                while(j > i && nums[j] == nums[j+1]){
                                                        j--;
                                                }
                                        } else if(nums[i] + nums[j] + nums[k] < 0){
                                                i++;
                                        } else {
                                                j--;
                                        }
                                }
                        }
                }
                return list;
        }
}