public class SubarrayOf1 {
    public int longestSubarray(int[] nums) {
        int left = 0, zero = 0, maxLen = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0) zero++;

            while(zero > 1){
                if(nums[left] == 0){
                    zero--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, i-left+1);
        }
        return maxLen - 1;
    }
}

