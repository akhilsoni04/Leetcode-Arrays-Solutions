import java.util.*;
public class DivideArrayMaxDiff {
    public int[][] divideArray(int[] nums, int k) {
        int n =  nums.length;
        if(n % 3 != 0) return new int[0][0];
        
        Arrays.sort(nums);

        int [][] result = new int[n/3][3];
        int resultIndex = 0;
        
        for(int i=0; i<n; i+=3){
            if(nums[i+2] - nums[i] <= k){
                result[resultIndex][0] = nums[i];
                result[resultIndex][1] = nums[i+1];
                result[resultIndex][2] = nums[i+2];

                resultIndex++;
            }
            else {
                return new int[0][0];
            }
        }
        return result;
    }
}

// space complexity is O(N)
// space complexity is O(N)