public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int window = 0;
        int maxLen = nums.length + 1; // Or we use Integer.MAX_VALUE;
        int left = 0;

        for(int right = 0; right<nums.length; right++){
            window += nums[right];

            while(window >= target){
                maxLen = Math.min(maxLen, right-left +1);
                window -= nums[left++];
            }
        }
        return maxLen == nums.length+1 ? 0 : maxLen ;

    }
}

//array sliding window standar question