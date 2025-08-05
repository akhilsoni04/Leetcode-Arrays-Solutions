public class FruitIntoBasketTWO {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
    int n = fruits.length;
    boolean[] used = new boolean[n];
    int unplaced = n;
    for (int f : fruits) {
        for (int i = 0; i < n; i++) {
            if (!used[i] && baskets[i] >= f) {
                used[i] = true;
                unplaced--;
                break;
            }
        }
    }
    return unplaced;
    }
}
