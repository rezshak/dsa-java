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

    private void indirectRecursionB(int n) {
        if (n > 1) {
            System.out.printf("%d ", n);
            indirectRecursionA(n / 2);
        }
    }

    public static void main(String[] args) {
        Recursion rec = new Recursion();
//        rec.tailRecursion(3);
//        rec.tailLoop(3);
//        rec.headRecursion(3);
//        rec.headLoop(3);
        rec.indirectRecursionA(16);
    }

}
