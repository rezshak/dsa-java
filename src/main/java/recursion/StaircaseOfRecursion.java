package recursion;

import java.util.HashMap;
import java.util.Map;

public final class StaircaseOfRecursion {
    static Map<Integer, Integer> CACHE = new HashMap<>();

    static {
        CACHE.put(1, 1);
        CACHE.put(2, 1);
    }

    public static int waysToClimb(int num) {
        if (CACHE.get(num + 1) == null) {
            CACHE.put(num + 1, waysToClimb(num - 1) + waysToClimb(num - 2));
        }
        return CACHE.get(num + 1);
    }

    public static void main(String[] args) {
        System.out.println(waysToClimb(5));
    }
}
