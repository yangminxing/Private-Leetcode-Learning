package yangminxing.leetcode.UniqueBinarySearchTrees;

import java.util.HashMap;
import java.util.Map;

public class UniqueBinarySearchTrees {

    public static void main(String[] args) {
        UniqueBinarySearchTrees sol =new UniqueBinarySearchTrees();
        System.out.println(sol.numTrees(3));
    }

    public int numTrees(int n) {
        return findTrees(new HashMap<>(), n);
    }

    public int findTrees(Map<Integer, Integer> quickmap, int n) {
        if(quickmap.containsKey(n)){
            return quickmap.get(n);
        }
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res += findTrees(quickmap, i) * findTrees(quickmap,n - i - 1);
        }
        quickmap.put(n, res);
        return res;
    }
}
