/*
        You have a total of n coins that you want to form in a staircase shape, 
        where every k-th row must have exactly k coins.
        Given n, find the total number of full staircase rows that can be formed.
        n is a non-negative integer and fits within the range of a 32-bit signed integer.

        Example 1:
        n = 5
        The coins can form the following rows:
                ¤
                ¤ ¤
                ¤ ¤
        Because the 3rd row is incomplete, we return 2.

        Example 2:
        n = 8
        The coins can form the following rows:
                ¤
                ¤ ¤
                ¤ ¤ ¤
                ¤ ¤
        Because the 4th row is incomplete, we return 3.
*/
class Solution {
        public int arrangeCoins(int n) {
                long low = 0, high = n;
                while(low <= high){
                        long mid = low + (high - low)/2;
                        long sum = sumOfN(mid);
                        if(sum == n){
                                return (int)mid;
                        } else if(sum > n){
                                high = mid - 1;
                        } else {
                                low = mid + 1;
                        }
                }
                return (int)high;
        }
        
        private long sumOfN(long n){
                return (n * (n + 1))/2;
        }
}