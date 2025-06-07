public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        
        for(int i=0; i<height.length-1; i++){
            int currentArea = Math.min(height[left], height[right]) * (right-left);
            maxArea =  Math.max(currentArea, maxArea);

            if(height[left] < height[right]) left ++;
            else right--;
        }
        return maxArea;
    }
}


// Time Complexity: O(n)
// Space Complexity: O(1)