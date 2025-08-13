import java.util.*;
class minSoldiers {
    public int minSoldiersTywanWar(int[] arr, int k) {
        int n = arr.length;
        int target = (n + 1) / 2; // ceil(n/2)
        
        int luckyCount = 0;
        List<Integer> needed = new ArrayList<>();
        
        for (int x : arr) {
            if (x % k == 0) {
                luckyCount++;
            } else {
                needed.add(k - (x % k));
            }
        }
        
        if (luckyCount >= target) {
            return 0;
        }
        
        Collections.sort(needed);
        
        int troopsNeeded = target - luckyCount;
        int soldiersAdded = 0;
        
        for (int i = 0; i < troopsNeeded; i++) {
            soldiersAdded += needed.get(i);
        }
        return soldiersAdded;
    }
}
