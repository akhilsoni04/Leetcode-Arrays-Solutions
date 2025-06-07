import java.util.*;
class lengthOfLongestSubstring {
    public int substringLength(String s) {
        int n = s.length();
        int left = 0;
        int maxLength = 0;

        HashSet<Character> set = new HashSet<>();
        for(int i=0; i<n; i++){
            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(i));
            maxLength = Math.max(maxLength, i-left+1);
        }
        return maxLength;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(min(n, m))
