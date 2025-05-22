import java.util.*;
public class Two_Sum_1{
    public static void main(String[] args) {
        //Take array as a input
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int nums[] = new int[size];

        for(int i=0; i<nums.length; i++){
            nums[i] = sc.nextInt();
        }

        // Input target
        int target = sc.nextInt();

        //convert Array to string because  If you print an array directly, it will print its address
        int result[] = twoSum(nums, target);

        System.err.println(Arrays.toString(result));
        sc.close();
    }

    public static int[] twoSum(int nums[], int target){
        // Solve using HashMap
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]) , i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}