package recursion;

public class TowerOfHanoi {

    static int towerOfHanoi(int discs) {
        return (int) (Math.pow(2, discs) - 1);
    }

    static void towerOfHanoiRecursive(int discs, String src, String dst, String aux) {
        if (discs == 1)
            System.out.println("> Moving disc from " + src + " to " + dst);
        else {
            towerOfHanoiRecursive(discs - 1, src, aux, dst);
            System.out.println(">> Moving disc from " + src + " to " + aux);
            towerOfHanoiRecursive(discs - 1, aux, src, dst);
        }
    }

    public static void main(String[] args) {
        towerOfHanoiRecursive(3, "A", "B", "C");
        System.out.println(towerOfHanoi(3));
    }

}
