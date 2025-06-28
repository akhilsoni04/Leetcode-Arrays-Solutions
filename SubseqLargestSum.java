import java.util.*;
public class SubseqLargestSum {
    
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[][] valueWithIndex = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            valueWithIndex[i][0] = nums[i]; 
            valueWithIndex[i][1] = i;    
        }

        Arrays.sort(valueWithIndex, (a, b) -> b[0] - a[0]);

        List<int[]> selected = Arrays.asList(Arrays.copyOfRange(valueWithIndex, 0, k));

        selected.sort((a, b) -> a[1] - b[1]);

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = selected.get(i)[0];
        }
        return result;
    }
}           
