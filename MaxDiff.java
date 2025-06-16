public class MaxDiff {
    public int maximumDifference(int[] nums) {
        int small = Integer.MAX_VALUE;
        int big = -1;
        for(int num : nums){
            if(num < small){
                small = num;
            }else if(num - small > 0){
                big = Math.max(big , num - small);
            }
        }
        return big;
    }
}
