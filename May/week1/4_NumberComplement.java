/* 
    Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation. 

    Example 1:

    Input: 5
    Output: 2
    Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
    
    Example 2:

    Input: 1
    Output: 0
    Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.

    Note:

    1. The given integer is guaranteed to fit within the range of a 32-bit signed integer.
    2. You could assume no leading zero bit in the integer’s binary representation.
    3. This question is the same as 1009: https://leetcode.com/problems/complement-of-base-10-integer/
*/


public class Solution {
        public int findComplement(int num) {
            int count = largestSetBit(num);
            int allSetBitNumber = (1 << (count + 1)) - 1;
            return allSetBitNumber ^ num;
        }
        
        private int largestSetBit(int num) {
            int i = 31;
            for(; i >= 0; i--){
                if(((1 << i) & num) > 0){
                    return i;
                }
            }
            return 0;
        }
}