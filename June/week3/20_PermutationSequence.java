/*
        The set [1,2,3,...,n] contains a total of n! unique permutations.
        By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
        "123"
        "132"
        "213"
        "231"
        "312"
        "321"
        Given n and k, return the kth permutation sequence.

        Note:
        1. Given n will be between 1 and 9 inclusive.
        2. Given k will be between 1 and n! inclusive.

        Example 1:
        Input: n = 3, k = 3
        Output: "213"

        Example 2:
        Input: n = 4, k = 9
        Output: "2314"
*/
class Solution {
        public String getPermutation(int n, int k) {
                int[] fact  = new int[n];
                fact[0]     = 1;
                for(int i = 1; i < n ; i++){
                        fact[i] = fact[i-1] * i;
                }
                
                List<Integer> list = new ArrayList();
                for(int i = 1; i <= n; i++){
                        list.add(i);
                }
                k--;
                StringBuilder str = new StringBuilder();
                while(n > 0){
                        int index = k / fact[n-1];
                        str.append(list.get(index));
                        list.remove(index);
                        k = k % fact[n-1];
                        n--;
                }
                
                return str.toString();
        }
}