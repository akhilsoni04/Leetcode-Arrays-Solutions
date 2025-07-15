// 26. Remove Duplicates from Sorted Array
// Time Complexity :	O(n)
// Space	Complexity : O(1)


class RemoveDuplicate {
    public int removeDuplicates(int[] nums) {
        int uniqueIndex = 1;

        for(int i=1; i<nums.length; i++){
            if(nums[i] != nums[i-1]) {
                nums[uniqueIndex] = nums[i];
                uniqueIndex++;
            }
        }
        return uniqueIndex;
    }
}
