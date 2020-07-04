/*
        Write a program to find the n-th ugly number.

        Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

        Example:
        Input: n = 10
        Output: 12
        Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

        Note:  
        - 1 is typically treated as an ugly number.
        - n does not exceed 1690.
*/
class Solution {
        public int nthUglyNumber(int n) {
                int[] ugly = new int[n];
                int i2 = 0, i3 = 0, i5 = 0;
                int next2 = 2, next3 = 3, next5 = 5, next = 1;
                for(int i = 1; i < n ; i++){
                        next    = Math.min(next2, Math.min(next3, next5));
                        ugly[i] = next;
                        if(next == next2){
                                i2++;
                                next2 = ugly[i2] * 2;
                        }
                        if(next == next3){
                                i3++;
                                next3 = ugly[i3] * 3;
                        }
                        if(next == next5){
                                i5++;
                                next5 = ugly[i5] * 5;
                        }
                }
                return next;
        }
}