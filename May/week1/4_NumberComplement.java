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