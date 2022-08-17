package main.java.recursion;

public class RecurrenceRelations {

    // T(n) = T(n - 1) + 1
    void Test1(int n) {
        if (n >  0) {
            System.out.printf("%dn\n", n);
            Test1(n - 1);
        }
    }

    // T(n) = T(n - 1) + n
    void TestN(int n) {
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                System.out.printf("%dn\n", n);
            }
            TestN(n - 1);
        }
    }

    // T(n) = T(n - 1) + log n
    void TestLogN(int n) {
        if (n > 0) {
            for (int i = 1; i < n; i *= 2) {
                System.out.printf("%dn\n", n);
            }
            TestLogN(n - 1);
        }
    }

    // T(n) = 2T(n - 1) + 1
    void Test2T(int n) {
        if (n > 0) {
            System.out.printf("%dn\n", n);
            Test2T(n - 1);
            Test2T(n - 1);
        }
    }

    public static void main(String[] args) {

    }

}
