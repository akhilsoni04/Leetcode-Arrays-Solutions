import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class UnionOfDuplicate {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        // code here
        Set<Integer> set = new TreeSet<>();
        for(int i:a)set.add(i);
        for(int i:b)set.add(i);
        return new ArrayList<>(set);
    }
}
