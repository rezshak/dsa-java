package recursion;

import static java.lang.String.format;

public class TowerOfHanoi {

    static int towerOfHanoi(int discs) {
        return (int) (Math.pow(2, discs) - 1);
    }

    static void towerOfHanoiRecursive(int discs, String src, String dst, String aux) {
        if (discs == 1) shift(1, src, dst);
        else {
            towerOfHanoiRecursive(discs - 1, src, aux, dst);
            shift(discs, src, dst);
            towerOfHanoiRecursive(discs - 1, aux, dst, src);
        }
    }

    static void towerOfHanoiRecursive2(int discs, String src, String dst, String aux) {
        if (discs == 0) return;
        towerOfHanoiRecursive2(discs - 1, src, aux, dst);
        shift(discs - 1, src, dst);
        towerOfHanoiRecursive2(discs - 1, aux, dst, src);
    }

    private static void shift(int disc, String src, String dst) {
        System.out.printf("> Moving disc '%d' from '%s' to '%s'%n", disc, src, dst);
    }

    public static void main(String[] args) {
        towerOfHanoiRecursive(3, "A", "B", "C");
        System.out.println(towerOfHanoi(3));
    }

}
