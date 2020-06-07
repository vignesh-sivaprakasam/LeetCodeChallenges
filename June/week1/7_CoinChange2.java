/*
        You are given coins of different denominations and a total amount of money. 
        Write a function to compute the number of combinations that make up that amount. 
        You may assume that you have infinite number of each kind of coin.        

        Example 1:
        Input      : amount = 5, coins = [1, 2, 5]
        Output     : 4
        Explanation: there are four ways to make up the amount:
        5=5
        5=2+2+1
        5=2+1+1+1
        5=1+1+1+1+1

        Example 2:
        Input      : amount = 3, coins = [2]
        Output     : 0
        Explanation: the amount of 3 cannot be made up just with coins of 2.

        Example 3:
        Input : amount = 10, coins = [10]
        Output: 1
        
        Note:
        You can assume that

        1. 0 <= amount <= 5000
        2. 1 <= coin <= 5000
        3. the number of coins is less than 500
        4. the answer is guaranteed to fit into signed 32-bit integer
*/
class Solution {
        public int change(int amount, int[] coins) {
            return helper(coins, amount);
        }
        
        private int helper(int[] coins, int index, int amount){
                if(index >= coins.length || amount < 0){
                        return 0;
                }
                if(amount == coins[index]){
                        return 1;
                }
                int one = 0;
                if(amount >= coins[index]){
                        one = helper(coins, index + 1, amount);
                }
                int two = helper(coins, index, amount - coins[index]);
                return one + two;
        }
        
        private int helper(int[] coins, int amount){
                int[][] dp = new int[coins.length + 1][amount + 1];
                dp[0][0]   = 1;
                for(int i = 1; i <= coins.length; i++){
                        dp[i][0] = 1;
                        for(int am = 1; am <= amount; am++){
                                dp[i][am] += dp[i-1][am]; // without including the coin
                                if(am >= coins[i-1]){
                                        dp[i][am] += dp[i][am - coins[i-1]];
                                }
                        }
                }
                return dp[coins.length][amount];
        }
    }