package main.java;

class Recursion {

    void tailRecursion(int n) {
        if (n > 0) {
            System.out.println(n);
            tailRecursion(n - 1);
        }
    }

    void tailLoop(int n) {
        while (n > 0) {
            System.out.printf("%d ", n);
            n--;
        }
    }

    void headRecursion(int n) {
        if (n > 0) {
            headRecursion(n - 1);
            System.out.printf("%d ", n);
        }
    }

    void headLoop(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.printf("%d ", n);
        }
    }

    void indirectRecursionA(int n) {
        if (n > 0) {
            System.out.printf("%d ", n);
            indirectRecursionB(n - 1);
        }
    }

    void indirectRecursionB(int n) {
        if (n > 1) {
            System.out.printf("%d ", n);
            indirectRecursionA(n / 2);
        }
    }

    int nestedRecursion(int n) {
        if (n > 100) {
            System.out.printf("%d ", n);
            return n - 10;
        }
        else return nestedRecursion(nestedRecursion(n + 11));
    }

    public static void main(String[] args) {
        Recursion rec = new Recursion();
//        rec.tailRecursion(3);
//        rec.tailLoop(3);
//        rec.headRecursion(3);
//        rec.headLoop(3);
//        rec.indirectRecursionA(16);
        System.out.println(rec.nestedRecursion(95));
    }

}
